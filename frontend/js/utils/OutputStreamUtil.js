import { MessageBoxControl } from "../components/MessageBoxControl.js";
import StringUtil from "./StringUtil.js";
export default class OutputStreamUtil {
    static getUserMedia(callBackFun) {
        if (!StringUtil.chkObjNull(this.userMediaStream)) {
            callBackFun(this.userMediaStream);
            return;
        }
        navigator.mediaDevices.getUserMedia({
            audio: true,
            video: true
        }).then(stream => {
            this.userMediaStream = stream;
            callBackFun(stream);
            stream.getTracks().forEach(track => {
                track.onended = () => {
                    MessageBoxControl.open("Authorizing failed, please reload the page.", () => window.location.reload());
                };
            });
        }).catch(() => {
            MessageBoxControl.open("Permission has not been granted to video chat!", () => window.location.reload());
        });
    }
    static getDisplayMedia(callBackFun, errorCallBackFun) {
        if (!StringUtil.chkObjNull(this.displayMediaStream)) {
            callBackFun(this.displayMediaStream);
            return;
        }
        navigator.mediaDevices.getDisplayMedia({
            audio: true,
            video: true
        }).then(stream => {
            this.displayMediaStream = stream;
            stream.getVideoTracks()[0].onended = () => {
                errorCallBackFun();
                this.displayMediaStream = null;
            };
            callBackFun(stream);
        }).catch(() => {
            MessageBoxControl.open("Permission has not been granted for screen sharing!", () => {
                errorCallBackFun();
            });
        });
    }
}

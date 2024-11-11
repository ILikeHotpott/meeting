import { BaseUrl } from "../api/ApiConstant.js";
import { MessageBoxControl } from "../components/MessageBoxControl.js";
import EventStant from "../constant/EventStant.js";
import StringUtil from "../utils/StringUtil.js";
export default class SseService {
    constructor(url, parm) {
        this.eventSource = new EventSource(BaseUrl.url + url + parm);
    }
    start(callBackFun) {
        this.eventSource.onopen = _ => callBackFun();
        this.bindHandleExceptionEvent();
        return this;
    }
    bindEvent(event, callBackFun) {
        this.eventSource.addEventListener(event, e => callBackFun(JSON.parse(e.data)));
        return this;
    }
    bindDefaultEvent(callBackFun) {
        this.eventSource.addEventListener('message', e => callBackFun(JSON.parse(e.data)));
        return this;
    }
    bindHandleExceptionEvent() {
        this.eventSource.addEventListener(EventStant.HANDLE_EXCEPTION, e => {
            const exceptionInfo = JSON.parse(e.data);
            if (!StringUtil.chkObjNull(exceptionInfo.statue) && exceptionInfo.statue === 400) {
                MessageBoxControl.open("Network error, try again later." + exceptionInfo.message, () => window.location.reload());
            }
        });
    }
    close() {
        this.eventSource.close();
    }
}

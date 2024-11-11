import { MessageBoxControl } from "./MessageBoxControl.js";
class TvBoxControl {
    static run() {
        this.tvBoxEl = document.querySelector('.tv-box');
        this.tvHeaderBoxEl = document.querySelector('.tv-header-box');
        this.tvHeaderSpanEl = document.querySelector('.tv-header-box > span');
        this.tvBodyBoxEl = document.querySelector('.tv-body-box');
        this.tvFooterBoxEl = document.querySelector('.tv-footer-box');
        this.listerClickEvent();
    }
    static bindEvent(openCallBackFun, closeCallBackFun) {
        this.openCallBackFun = openCallBackFun;
        this.closeCallBackFun = closeCallBackFun;
    }
    static listerClickEvent() {
        this.tvBoxEl.addEventListener('click', () => {
            if (!this.switch) {
                if (this.isOnce) {
                    this.isOnce = false;
                    MessageBoxControl.open("When screen sharing is turned on, if you click the Stop Sharing that comes with your browser, the screen you want to share will be reselected the next time, or if you click the icon that comes with this website, the screen you selected last time will be used for sharing.", () => {
                        this.open();
                    });
                    return;
                }
                this.open();
            }
            else {
                this.close();
            }
        });
    }
    static open() {
        this.switch = true;
        this.tvHeaderBoxEl.style.borderColor = 'green';
        this.tvHeaderSpanEl.style.color = 'green';
        this.tvBodyBoxEl.style.backgroundColor = 'green';
        this.tvFooterBoxEl.style.backgroundColor = 'green';
        this.openCallBackFun();
    }
    static close() {
        this.publicClose();
        this.closeCallBackFun();
    }
    static publicClose() {
        this.switch = false;
        this.tvHeaderBoxEl.style.borderColor = 'rgba(255, 255, 255, 0.747)';
        this.tvHeaderSpanEl.style.color = 'rgba(255, 255, 255, 0.747)';
        this.tvBodyBoxEl.style.backgroundColor = 'rgba(255, 255, 255, 0.747)';
        this.tvFooterBoxEl.style.backgroundColor = 'rgba(255, 255, 255, 0.747)';
    }
}
TvBoxControl.switch = false;
TvBoxControl.isOnce = true;
export default TvBoxControl;

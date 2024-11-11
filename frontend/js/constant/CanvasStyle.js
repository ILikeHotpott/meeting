var _a;

class CanvasStyle {
    static getStyleMap() {
        return this.styleMap;
    }
}

_a = CanvasStyle;
(() => {
    _a.styleMap = new Map();
    _a.styleMap.set("original", "original");
    _a.styleMap.set("grayscale", "grayscale");
    _a.styleMap.set("sepia", "sepia");
    _a.styleMap.set("invert", "invert");
    _a.styleMap.set("applyBeautyEffect", "applyBeautyEffect");
    _a.styleMap.set("characterize", "characterize");
})();
export default CanvasStyle;

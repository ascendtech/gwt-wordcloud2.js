package us.ascendtech.wordcloud2js.client;

import elemental2.core.JsArray;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(namespace = JsPackage.GLOBAL, isNative = true, name = "Object")
public class WordCloud2JSOptions {

	private JsArray<JsArray<Object>> list;
	private String fontFamily;
	private String fontWeight;
	private String color;
	private Color colorFn;
	private Double minSize;
	private Double weightFactor;
	private WeightFactor weightFactorFn;
	private Boolean clearCanvas;
	private String backgroundColor;
	private Double gridSize;
	private Boolean drawOutOfBound;
	private Boolean shrinkToFit;
	private JsArray<Double> origin; // [x, y]
	private Boolean drawMask;
	private String maskColor;
	private Double maskGapWidth;
	private Double wait;
	private Double abortThreshold;
	private Abort abort;
	private Double minRotation;
	private Double maxRotation;
	private Double rotationSteps;
	private Boolean shuffle;
	private Double rotateRatio;
	private String shape;
	private Double ellipticity;
	private String classes;
	private Hover hover;
	private Click click;

	@JsFunction
	public interface Abort {
		void noop();
	}

	@JsFunction
	public interface Hover {
		void onHover(Object item);
	}

	@JsFunction
	public interface Click {
		void onClick(Object item);
	}

	@JsFunction
	public interface WeightFactor {
		Double getWeightFactor(Double size);
	}

	@JsFunction
	public interface Color {
		String getColor(Object item, Double weight);
	}

	@JsOverlay
	public final JsArray<JsArray<Object>> getList() {
		return list;
	}

	@JsOverlay
	public final WordCloud2JSOptions setList(JsArray<JsArray<Object>> list) {
		this.list = list;
		return this;
	}

	@JsOverlay
	public final String getFontFamily() {
		return fontFamily;
	}

	@JsOverlay
	public final WordCloud2JSOptions setFontFamily(String fontFamily) {
		this.fontFamily = fontFamily;
		return this;
	}

	@JsOverlay
	public final String getFontWeight() {
		return fontWeight;
	}

	@JsOverlay
	public final WordCloud2JSOptions setFontWeight(String fontWeight) {
		this.fontWeight = fontWeight;
		return this;
	}

	@JsOverlay
	public final WordCloud2JSOptions setColor(Color color) {
		this.colorFn = color;
		return this;
	}

	@JsOverlay
	public final WordCloud2JSOptions setColor(String color) {
		this.color = color;
		return this;
	}

	@JsOverlay
	public final String getColor() {
		return color;
	}

	@JsOverlay
	public final Double getMinSize() {
		return minSize;
	}

	@JsOverlay
	public final WordCloud2JSOptions setMinSize(Double minSize) {
		this.minSize = minSize;
		return this;
	}

	@JsOverlay
	public final WordCloud2JSOptions setWeightFactor(WeightFactor weightFactor) {
		this.weightFactorFn = weightFactor;
		return this;
	}

	@JsOverlay
	public final WordCloud2JSOptions setWeightFactor(Double weightFactor) {
		this.weightFactor = weightFactor;
		return this;
	}

	@JsOverlay
	public final Double getWeightFactor() {
		return weightFactor;
	}

	@JsOverlay
	public final Boolean getClearCanvas() {
		return clearCanvas;
	}

	@JsOverlay
	public final WordCloud2JSOptions setClearCanvas(Boolean clearCanvas) {
		this.clearCanvas = clearCanvas;
		return this;
	}

	@JsOverlay
	public final String getBackgroundColor() {
		return backgroundColor;
	}

	@JsOverlay
	public final WordCloud2JSOptions setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
		return this;
	}

	@JsOverlay
	public final Double getGridSize() {
		return gridSize;
	}

	@JsOverlay
	public final WordCloud2JSOptions setGridSize(Double gridSize) {
		this.gridSize = gridSize;
		return this;
	}

	@JsOverlay
	public final Boolean getDrawOutOfBound() {
		return drawOutOfBound;
	}

	@JsOverlay
	public final WordCloud2JSOptions setDrawOutOfBound(Boolean drawOutOfBound) {
		this.drawOutOfBound = drawOutOfBound;
		return this;
	}

	@JsOverlay
	public final Boolean getShrinkToFit() {
		return shrinkToFit;
	}

	@JsOverlay
	public final WordCloud2JSOptions setShrinkToFit(Boolean shrinkToFit) {
		this.shrinkToFit = shrinkToFit;
		return this;
	}

	@JsOverlay
	public final JsArray<Double> getOrigin() {
		return origin;
	}

	@JsOverlay
	public final WordCloud2JSOptions setOrigin(JsArray<Double> origin) {
		this.origin = origin;
		return this;
	}

	@JsOverlay
	public final Boolean getDrawMask() {
		return drawMask;
	}

	@JsOverlay
	public final WordCloud2JSOptions setDrawMask(Boolean drawMask) {
		this.drawMask = drawMask;
		return this;
	}

	@JsOverlay
	public final String getMaskColor() {
		return maskColor;
	}

	@JsOverlay
	public final WordCloud2JSOptions setMaskColor(String maskColor) {
		this.maskColor = maskColor;
		return this;
	}

	@JsOverlay
	public final Double getMaskGapWidth() {
		return maskGapWidth;
	}

	@JsOverlay
	public final WordCloud2JSOptions setMaskGapWidth(Double maskGapWidth) {
		this.maskGapWidth = maskGapWidth;
		return this;
	}

	@JsOverlay
	public final Double getWait() {
		return wait;
	}

	@JsOverlay
	public final WordCloud2JSOptions setWait(Double wait) {
		this.wait = wait;
		return this;
	}

	@JsOverlay
	public final Double getAbortThreshold() {
		return abortThreshold;
	}

	@JsOverlay
	public final WordCloud2JSOptions setAbortThreshold(Double abortThreshold) {
		this.abortThreshold = abortThreshold;
		return this;
	}

	@JsOverlay
	public final Double getMinRotation() {
		return minRotation;
	}

	@JsOverlay
	public final WordCloud2JSOptions setMinRotation(Double minRotation) {
		this.minRotation = minRotation;
		return this;
	}

	@JsOverlay
	public final Double getMaxRotation() {
		return maxRotation;
	}

	@JsOverlay
	public final WordCloud2JSOptions setMaxRotation(Double maxRotation) {
		this.maxRotation = maxRotation;
		return this;
	}

	@JsOverlay
	public final Double getRotationSteps() {
		return rotationSteps;
	}

	@JsOverlay
	public final WordCloud2JSOptions setRotationSteps(Double rotationSteps) {
		this.rotationSteps = rotationSteps;
		return this;
	}

	@JsOverlay
	public final Boolean getShuffle() {
		return shuffle;
	}

	@JsOverlay
	public final WordCloud2JSOptions setShuffle(Boolean shuffle) {
		this.shuffle = shuffle;
		return this;
	}

	@JsOverlay
	public final Double getRotateRatio() {
		return rotateRatio;
	}

	@JsOverlay
	public final WordCloud2JSOptions setRotateRatio(Double rotateRatio) {
		this.rotateRatio = rotateRatio;
		return this;
	}

	@JsOverlay
	public final String getShape() {
		return shape;
	}

	@JsOverlay
	public final WordCloud2JSOptions setShape(String shape) {
		this.shape = shape;
		return this;
	}

	@JsOverlay
	public final Double getEllipticity() {
		return ellipticity;
	}

	@JsOverlay
	public final WordCloud2JSOptions setEllipticity(Double ellipticity) {
		this.ellipticity = ellipticity;
		return this;
	}

	@JsOverlay
	public final String getClasses() {
		return classes;
	}

	@JsOverlay
	public final WordCloud2JSOptions setClasses(String classes) {
		this.classes = classes;
		return this;
	}

	@JsOverlay
	public final void setClick(Click click) {
		this.click = click;
	}

	@JsOverlay
	public final void setHover(Hover hover) {
		this.hover = hover;
	}

}

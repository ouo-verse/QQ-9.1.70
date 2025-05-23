package rn2;

import android.graphics.drawable.GradientDrawable;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.servlet.MiniAppGetTeenagerConfigServlet;
import com.tencent.mobileqq.search.searchdetail.util.SearchPicLoader;
import com.tencent.mobileqq.search.util.af;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.listitem.ab;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b-\u0010.J.\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J>\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007JA\u0010\u001a\u001a\u00020\u0018*\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00122!\u0010\u0019\u001a\u001d\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00180\u0014J\u0012\u0010\u001d\u001a\u00020\u0018*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0010J\u001a\u0010\u001f\u001a\u00020\u0018*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0007J\n\u0010!\u001a\u00020\u0018*\u00020 J\n\u0010\"\u001a\u00020\u0018*\u00020 J \u0010(\u001a\u00020$2\u0006\u0010#\u001a\u00020\u00102\u0006\u0010%\u001a\u00020$2\b\b\u0002\u0010'\u001a\u00020&J\n\u0010)\u001a\u00020\u0010*\u00020\u0010J\u0012\u0010,\u001a\u00020\u0018*\u00020 2\u0006\u0010+\u001a\u00020*\u00a8\u0006/"}, d2 = {"Lrn2/j;", "", "", "tl", ReportConstant.COSTREPORT_TRANS, TtmlNode.TAG_BR, "bl", "", "color", "Landroid/graphics/drawable/GradientDrawable;", "g", "stroke", NodeProps.BORDER_COLOR, "solidColor", "f", "Landroid/view/View;", "", "tag", "", MiniAppGetTeenagerConfigServlet.KEY_TIME_INTERVAL, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "v", "", "clickFun", "t", "Landroid/widget/ImageView;", "url", "p", "fixedHeight", DomainData.DOMAIN_NAME, "Landroid/widget/TextView;", "l", tl.h.F, "highlightWord", "", "content", "", "ignoreCase", "j", "r", "Landroid/text/Spannable;", "spannable", ReportConstant.COSTREPORT_PREFIX, "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class j {

    /* renamed from: a */
    @NotNull
    public static final j f431768a = new j();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"rn2/j$a", "Landroid/view/View$OnTouchListener;", "Landroid/view/View;", "v", "Landroid/view/MotionEvent;", "event", "", "onTouch", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class a implements View.OnTouchListener {

        /* renamed from: d */
        final /* synthetic */ Spannable f431769d;

        a(Spannable spannable) {
            this.f431769d = spannable;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(@NotNull View v3, @NotNull MotionEvent event) {
            boolean z16;
            Intrinsics.checkNotNullParameter(v3, "v");
            Intrinsics.checkNotNullParameter(event, "event");
            int action = event.getAction();
            if (!(v3 instanceof TextView)) {
                return false;
            }
            if (action == 0 || action == 1) {
                float x16 = event.getX();
                float totalPaddingLeft = (x16 - r4.getTotalPaddingLeft()) + r4.getScrollX();
                float y16 = (event.getY() - r4.getTotalPaddingTop()) + r4.getScrollY();
                Layout layout = ((TextView) v3).getLayout();
                int lineForVertical = layout.getLineForVertical((int) y16);
                int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, totalPaddingLeft);
                ClickableSpan[] link = (ClickableSpan[]) this.f431769d.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                Intrinsics.checkNotNullExpressionValue(link, "link");
                if (link.length == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    if (lineForVertical >= layout.getLineCount() - 1 && totalPaddingLeft > layout.getLineWidth(lineForVertical)) {
                        return false;
                    }
                    if (action != 0) {
                        if (action == 1) {
                            link[0].onClick(v3);
                        }
                    } else {
                        Spannable spannable = this.f431769d;
                        Selection.setSelection(spannable, spannable.getSpanStart(link[0]), this.f431769d.getSpanEnd(link[0]));
                    }
                    return true;
                }
                Selection.removeSelection(this.f431769d);
            }
            return false;
        }
    }

    j() {
    }

    public static final void i(TextView this_getCutTextInMultiChatRecordForFixedWidth, CharSequence source) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this_getCutTextInMultiChatRecordForFixedWidth, "$this_getCutTextInMultiChatRecordForFixedWidth");
        Intrinsics.checkNotNullParameter(source, "$source");
        int width = (this_getCutTextInMultiChatRecordForFixedWidth.getWidth() - ab.a(this_getCutTextInMultiChatRecordForFixedWidth)) - 16;
        ForegroundColorSpan[] foregroundColorSpans = (ForegroundColorSpan[]) ((Spanned) source).getSpans(0, source.length(), ForegroundColorSpan.class);
        Intrinsics.checkNotNullExpressionValue(foregroundColorSpans, "foregroundColorSpans");
        if (foregroundColorSpans.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            int spanEnd = ((Spanned) source).getSpanEnd(foregroundColorSpans[0]);
            TextPaint paint = this_getCutTextInMultiChatRecordForFixedWidth.getPaint();
            String obj = source.toString();
            QLog.i("SearchViewUtil", 4, "getCutTextInMultiChatRecordForFixedWidth___   spans.size:" + foregroundColorSpans.length + " showContentWidth:" + width + " cutEnd:" + spanEnd);
            if (spanEnd >= 0) {
                float f16 = width;
                if (paint.measureText(obj) >= f16) {
                    int i3 = spanEnd - 1;
                    while (i3 >= 0 && (paint.measureText(obj) - paint.measureText(l.l(obj, i3, spanEnd))) + paint.measureText("\u2026") > f16) {
                        i3--;
                    }
                    Pair<Integer, Integer> k3 = l.k(obj, Math.max(i3, 0), spanEnd);
                    this_getCutTextInMultiChatRecordForFixedWidth.setText(new SpannableStringBuilder(source).replace(k3.getFirst().intValue(), k3.getSecond().intValue(), (CharSequence) "\u2026"));
                }
            }
        }
    }

    public static /* synthetic */ CharSequence k(j jVar, String str, CharSequence charSequence, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        return jVar.j(str, charSequence, z16);
    }

    public static final void m(TextView this_highlightSpanShowMiddleInSingleLine, CharSequence source) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this_highlightSpanShowMiddleInSingleLine, "$this_highlightSpanShowMiddleInSingleLine");
        Intrinsics.checkNotNullParameter(source, "$source");
        int width = this_highlightSpanShowMiddleInSingleLine.getWidth() - ab.a(this_highlightSpanShowMiddleInSingleLine);
        ForegroundColorSpan[] foregroundColorSpans = (ForegroundColorSpan[]) ((Spanned) source).getSpans(0, source.length(), ForegroundColorSpan.class);
        QLog.i("SearchViewUtil", 4, "highlightSpanShowMiddleInSingleLine___   spans.size:" + foregroundColorSpans.length);
        Intrinsics.checkNotNullExpressionValue(foregroundColorSpans, "foregroundColorSpans");
        if (foregroundColorSpans.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            Spanned spanned = (Spanned) source;
            int spanStart = spanned.getSpanStart(foregroundColorSpans[0]);
            int spanEnd = spanned.getSpanEnd(foregroundColorSpans[0]);
            TextPaint paint = this_highlightSpanShowMiddleInSingleLine.getPaint();
            CharSequence subSequence = source.subSequence(0, spanEnd);
            StringBuilder sb5 = new StringBuilder();
            sb5.append((Object) subSequence);
            String str = "\u2026";
            sb5.append("\u2026");
            float f16 = width;
            if (paint.measureText(sb5.toString()) >= f16) {
                while (true) {
                    if (spanStart > 0) {
                        spanStart--;
                        if (paint.measureText(source.subSequence(spanStart, spanEnd).toString() + "\u2026\u2026") >= f16) {
                            spanStart++;
                            break;
                        }
                    }
                    if (spanEnd < source.length()) {
                        spanEnd++;
                        if (paint.measureText(source.subSequence(spanStart, spanEnd).toString() + "\u2026\u2026") >= f16) {
                            spanEnd--;
                            break;
                        }
                    }
                    if (spanStart == 0 && spanEnd == source.length()) {
                        break;
                    }
                }
                if (spanStart == 0) {
                    str = "";
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(source.subSequence(spanStart, spanEnd));
                QLog.i("SearchViewUtil", 1, "highlightSpanShowMiddleInSingleLine___   startOffset:" + spanStart + "       endOffset:" + spanEnd + "     prefix:" + str);
                this_highlightSpanShowMiddleInSingleLine.setText(new QQText(spannableStringBuilder, 3, 15).append(str, true, new int[0]));
            }
        }
    }

    public static final void o(int i3, ImageView this_initUriWithAdjustWidth, LoadState loadState, Option option) {
        Intrinsics.checkNotNullParameter(this_initUriWithAdjustWidth, "$this_initUriWithAdjustWidth");
        if (loadState == LoadState.STATE_SUCCESS) {
            int width = option.getResultBitMap().getWidth();
            int height = option.getResultBitMap().getHeight();
            if (width != 0 && height != 0) {
                this_initUriWithAdjustWidth.getLayoutParams().width = (int) (i3 * (width / height));
                this_initUriWithAdjustWidth.requestLayout();
            }
        }
    }

    public static final void q(String url, LoadState loadState, Option option) {
        Intrinsics.checkNotNullParameter(url, "$url");
        if (loadState != LoadState.STATE_SUCCESS) {
            af afVar = af.f284993a;
            QLog.w("QS.SearchViewUtil", 1, "loadSvg failed " + url, null);
        }
    }

    public static /* synthetic */ void u(j jVar, View view, String str, long j3, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "";
        }
        String str2 = str;
        if ((i3 & 2) != 0) {
            j3 = 500;
        }
        jVar.t(view, str2, j3, function1);
    }

    public static final void v(String tag, long j3, Function1 clickFun, View it) {
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(tag, "$tag");
        Intrinsics.checkNotNullParameter(clickFun, "$clickFun");
        if (tag.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            tag = it.toString();
            Intrinsics.checkNotNullExpressionValue(tag, "it.toString()");
        }
        if (!FastClickUtils.isFastDoubleClick(tag, j3)) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            clickFun.invoke(it);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    @NotNull
    public final GradientDrawable f(float tl5, float r65, float r75, float bl5, int stroke, int r102, int solidColor) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setStroke(stroke, r102);
        gradientDrawable.setCornerRadii(new float[]{tl5, tl5, r65, r65, r75, r75, bl5, bl5});
        gradientDrawable.setColor(solidColor);
        return gradientDrawable;
    }

    @NotNull
    public final GradientDrawable g(float tl5, float r65, float r75, float bl5, int color) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadii(new float[]{tl5, tl5, r65, r65, r75, r75, bl5, bl5});
        gradientDrawable.setColor(color);
        return gradientDrawable;
    }

    public final void h(@NotNull final TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        final CharSequence text = textView.getText();
        Intrinsics.checkNotNullExpressionValue(text, "this.text");
        if (text instanceof Spanned) {
            textView.post(new Runnable() { // from class: rn2.e
                @Override // java.lang.Runnable
                public final void run() {
                    j.i(textView, text);
                }
            });
        }
    }

    @NotNull
    public final CharSequence j(@NotNull String highlightWord, @NotNull CharSequence content, boolean ignoreCase) {
        int indexOf$default;
        Intrinsics.checkNotNullParameter(highlightWord, "highlightWord");
        Intrinsics.checkNotNullParameter(content, "content");
        indexOf$default = StringsKt__StringsKt.indexOf$default(content, highlightWord, 0, ignoreCase, 2, (Object) null);
        if (indexOf$default != -1) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(content);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(BaseApplication.getContext().getColor(R.color.qui_common_brand_standard)), indexOf$default, highlightWord.length() + indexOf$default, 18);
            return spannableStringBuilder;
        }
        return content;
    }

    public final void l(@NotNull final TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        final CharSequence text = textView.getText();
        Intrinsics.checkNotNullExpressionValue(text, "this.text");
        if (text instanceof Spanned) {
            textView.post(new Runnable() { // from class: rn2.f
                @Override // java.lang.Runnable
                public final void run() {
                    j.m(textView, text);
                }
            });
        }
    }

    public final void n(@NotNull final ImageView imageView, @NotNull String url, final int i3) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        Option option = Option.obtain().setUrl(url).setTargetView(imageView);
        SearchPicLoader searchPicLoader = SearchPicLoader.f284726a;
        Intrinsics.checkNotNullExpressionValue(option, "option");
        searchPicLoader.e(option, new IPicLoadStateListener() { // from class: rn2.g
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option2) {
                j.o(i3, imageView, loadState, option2);
            }
        });
    }

    public final void p(@NotNull ImageView imageView, @NotNull final String url) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        Option option = Option.obtain().setPreferDecoder(e11.a.class).setUrl(url).setTargetView(imageView);
        SearchPicLoader searchPicLoader = SearchPicLoader.f284726a;
        Intrinsics.checkNotNullExpressionValue(option, "option");
        searchPicLoader.e(option, new IPicLoadStateListener() { // from class: rn2.i
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option2) {
                j.q(url, loadState, option2);
            }
        });
    }

    @NotNull
    public final String r(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new Regex("[\r\n]+").replace(str, "\u200b");
    }

    public final void s(@NotNull TextView textView, @NotNull Spannable spannable) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(spannable, "spannable");
        a aVar = new a(spannable);
        textView.setText(spannable);
        textView.setOnTouchListener(aVar);
    }

    public final void t(@NotNull View view, @NotNull final String tag, final long j3, @NotNull final Function1<? super View, Unit> clickFun) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(clickFun, "clickFun");
        view.setOnClickListener(new View.OnClickListener() { // from class: rn2.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                j.v(tag, j3, clickFun, view2);
            }
        });
    }
}

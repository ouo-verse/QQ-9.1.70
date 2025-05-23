package zw3;

import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqnt.graytips.decoder.GrayTipsDecoderProvider;
import com.tencent.qqnt.graytips.decoder.f;
import com.tencent.qqnt.graytips.util.h;
import com.tencent.qqnt.kernelpublic.nativeinterface.GrayTipElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0010\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u001a\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u0006\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/kernelpublic/nativeinterface/GrayTipElement;", DTConstants.TAG.ELEMENT, "", "c", "Lcom/tencent/qqnt/graytips/util/h$a;", "a", "", "b", "graytips_kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a {
    @NotNull
    public static final h.a a(@NotNull GrayTipElement element) {
        Intrinsics.checkNotNullParameter(element, "element");
        f fVar = GrayTipsDecoderProvider.INSTANCE.a().get(element.subElementType);
        if (fVar == null) {
            fVar = new com.tencent.qqnt.graytips.decoder.h();
        }
        return fVar.a(element);
    }

    @NotNull
    public static final String b(@NotNull String element) {
        Intrinsics.checkNotNullParameter(element, "element");
        QLog.d("GrayTipsContentUtil", 1, "[defaultText] " + element);
        String string = BaseApplication.context.getString(R.string.f237357gu);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026supported_gray_tips_type)");
        return string;
    }

    @NotNull
    public static final CharSequence c(@Nullable GrayTipElement grayTipElement) {
        if (grayTipElement == null) {
            return b("has no GrayTipElement");
        }
        String spannableStringBuilder = a(grayTipElement).f356916a.toString();
        Intrinsics.checkNotNullExpressionValue(spannableStringBuilder, "decodeGrayTipsText(element).ssbContent.toString()");
        return spannableStringBuilder;
    }
}

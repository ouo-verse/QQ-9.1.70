package xd1;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.mobileqq.gamecenter.qa.editor.span.AbsoluteSizeSpan;
import com.tencent.mobileqq.gamecenter.qa.editor.span.AlignmentSpan;
import com.tencent.mobileqq.gamecenter.qa.editor.span.BoldSpan;
import com.tencent.mobileqq.gamecenter.qa.editor.span.ItalicSpan;
import com.tencent.mobileqq.gamecenter.qa.editor.span.UnderlineSpan;
import com.tencent.mobileqq.gamecenter.qa.view.GameStrategyImageSpan;
import com.tencent.mobileqq.gamecenter.qa.view.ab;
import com.tencent.mobileqq.gamecenter.qa.view.w;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import yd1.b;
import yd1.c;
import yd1.d;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f447818b = Pattern.compile("\\r\\n|\\r|\\n");

    /* renamed from: a, reason: collision with root package name */
    private int f447819a = 0;

    private void b(d dVar, int i3, int i16, SpannableStringBuilder spannableStringBuilder, String str) {
        boolean z16;
        b.d dVar2;
        int i17 = i3;
        GameStrategyImageSpan[] gameStrategyImageSpanArr = (GameStrategyImageSpan[]) spannableStringBuilder.getSpans(i17, i16, GameStrategyImageSpan.class);
        if (gameStrategyImageSpanArr != null && gameStrategyImageSpanArr.length > 0) {
            for (GameStrategyImageSpan gameStrategyImageSpan : gameStrategyImageSpanArr) {
                GameStrategyImageSpan.b q16 = gameStrategyImageSpan.q();
                if (q16 != null) {
                    int i18 = q16.f212891a;
                    if (i18 == 0) {
                        c.a aVar = new c.a();
                        aVar.f450188c = q16.f212899i;
                        dVar.a().add(aVar);
                    } else if (i18 == 1) {
                        c.C11605c c11605c = new c.C11605c();
                        c11605c.f450192c = q16.f212899i;
                        dVar.a().add(c11605c);
                    }
                }
            }
            z16 = false;
        } else {
            z16 = true;
        }
        w[] wVarArr = (w[]) spannableStringBuilder.getSpans(i17, i16, w.class);
        if (wVarArr != null && wVarArr.length > 0) {
            for (w wVar : wVarArr) {
                c.b bVar = new c.b();
                bVar.f450189c = wVar.getIndex();
                bVar.f450191e = wVar.n();
                bVar.f450190d = wVar.k();
                bVar.f450189c = wVar.getIndex();
                dVar.a().add(bVar);
            }
            z16 = false;
        }
        if (z16) {
            yd1.b bVar2 = new yd1.b();
            zd1.b bVar3 = (zd1.b) c(spannableStringBuilder, (zd1.b[]) spannableStringBuilder.getSpans(i17, i16, zd1.b.class), i17);
            if (bVar3 != null) {
                b.C11604b c11604b = bVar2.f450173d;
                c11604b.f450176a = 1;
                c11604b.f450178c = bVar3.j();
                bVar2.f450173d.f450177b = 0;
            }
            zd1.c cVar = (zd1.c) c(spannableStringBuilder, (zd1.c[]) spannableStringBuilder.getSpans(i17, i16, zd1.c.class), i17);
            if (cVar != null) {
                b.C11604b c11604b2 = bVar2.f450173d;
                c11604b2.f450176a = 2;
                c11604b2.f450178c = cVar.i();
                bVar2.f450173d.f450177b = cVar.g();
            }
            AlignmentSpan[] alignmentSpanArr = (AlignmentSpan[]) spannableStringBuilder.getSpans(i17, i16, AlignmentSpan.class);
            if (alignmentSpanArr != null && alignmentSpanArr.length > 0) {
                if (alignmentSpanArr[0].getValue() == Layout.Alignment.ALIGN_OPPOSITE) {
                    bVar2.f450173d.f450179d = "right";
                } else if (alignmentSpanArr[0].getValue() == Layout.Alignment.ALIGN_CENTER) {
                    bVar2.f450173d.f450179d = "center";
                } else {
                    bVar2.f450173d.f450179d = "left";
                }
            } else {
                bVar2.f450173d.f450179d = "left";
            }
            AbsoluteSizeSpan[] absoluteSizeSpanArr = (AbsoluteSizeSpan[]) spannableStringBuilder.getSpans(i17, i16, AbsoluteSizeSpan.class);
            if (absoluteSizeSpanArr != null && absoluteSizeSpanArr.length > 0) {
                bVar2.f450173d.f450180e = ViewUtils.pxTosp(absoluteSizeSpanArr[0].getValue().intValue());
            }
            ArrayList arrayList = new ArrayList();
            while (i17 < i16) {
                int i19 = i17 + 1;
                ab[] abVarArr = (ab[]) spannableStringBuilder.getSpans(i17, i19, ab.class);
                if (abVarArr != null && abVarArr.length > 0) {
                    b.a aVar2 = new b.a();
                    aVar2.f450174f = abVarArr[0].getMLink();
                    aVar2.f450182b = abVarArr[0].getMTitle();
                    dVar2 = aVar2;
                } else {
                    b.d dVar3 = new b.d();
                    dVar3.f450182b = str.substring(i17, i19);
                    dVar2 = dVar3;
                }
                BoldSpan[] boldSpanArr = (BoldSpan[]) spannableStringBuilder.getSpans(i17, i19, BoldSpan.class);
                if (boldSpanArr != null && boldSpanArr.length > 0) {
                    dVar2.f450183c = true;
                }
                ItalicSpan[] italicSpanArr = (ItalicSpan[]) spannableStringBuilder.getSpans(i17, i19, ItalicSpan.class);
                if (italicSpanArr != null && italicSpanArr.length > 0) {
                    dVar2.f450185e = true;
                }
                UnderlineSpan[] underlineSpanArr = (UnderlineSpan[]) spannableStringBuilder.getSpans(i17, i19, UnderlineSpan.class);
                if (underlineSpanArr != null && underlineSpanArr.length > 0) {
                    dVar2.f450184d = true;
                }
                arrayList.add(dVar2);
                i17 = i19;
            }
            ArrayList arrayList2 = new ArrayList();
            int i26 = 0;
            while (i26 < arrayList.size() - 1) {
                b.c cVar2 = (b.c) arrayList.get(i26);
                i26++;
                b.c cVar3 = (b.c) arrayList.get(i26);
                if (cVar2.a(cVar3)) {
                    if (TextUtils.equals("text", cVar3.f450181a) && (cVar3 instanceof b.d) && (cVar2 instanceof b.d)) {
                        b.d dVar4 = (b.d) cVar3;
                        dVar4.f450182b = ((b.d) cVar2).f450182b + dVar4.f450182b;
                        QLog.d("ConverterSpannedToRichText", 2, "combination currentSection:", cVar2, " nextSection:", cVar3);
                    }
                } else {
                    arrayList2.add(cVar2);
                    QLog.d("ConverterSpannedToRichText", 2, "find diff section currentSection:", cVar2, " nextSection:", cVar3);
                }
            }
            if (!arrayList.isEmpty()) {
                arrayList2.add((b.c) arrayList.get(arrayList.size() - 1));
                QLog.d("ConverterSpannedToRichText", 2, "add end section:", arrayList.get(arrayList.size() - 1));
            }
            bVar2.f450172c.addAll(arrayList2);
            dVar.a().add(bVar2);
        }
    }

    private static Object c(SpannableStringBuilder spannableStringBuilder, Object[] objArr, int i3) {
        if (spannableStringBuilder != null && objArr != null && objArr.length > 0) {
            for (int i16 = 0; i16 < objArr.length; i16++) {
                if (spannableStringBuilder.getSpanStart(objArr[i16]) == i3) {
                    return objArr[i16];
                }
            }
            return null;
        }
        return null;
    }

    private SpannableStringBuilder d(SpannableStringBuilder spannableStringBuilder) {
        if (QLog.isColorLevel()) {
            QLog.d("ConverterSpannedToRichText", 2, "prepareSpannableString spanned:", spannableStringBuilder.toString());
        }
        GameStrategyImageSpan[] gameStrategyImageSpanArr = (GameStrategyImageSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), GameStrategyImageSpan.class);
        ArrayList arrayList = new ArrayList();
        if (gameStrategyImageSpanArr != null && gameStrategyImageSpanArr.length > 0) {
            for (GameStrategyImageSpan gameStrategyImageSpan : gameStrategyImageSpanArr) {
                int spanStart = spannableStringBuilder.getSpanStart(gameStrategyImageSpan);
                if (spanStart > 1 && !TextUtils.equals(spannableStringBuilder.subSequence(spanStart - 1, spanStart).toString(), "\n")) {
                    arrayList.add(Integer.valueOf(spanStart));
                }
            }
        }
        w[] wVarArr = (w[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), w.class);
        if (wVarArr != null && wVarArr.length > 0) {
            for (w wVar : wVarArr) {
                int spanStart2 = spannableStringBuilder.getSpanStart(wVar);
                if (spanStart2 > 1 && !TextUtils.equals(spannableStringBuilder.subSequence(spanStart2 - 1, spanStart2).toString(), "\n")) {
                    arrayList.add(Integer.valueOf(spanStart2));
                }
            }
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            spannableStringBuilder.insert(((Integer) arrayList.get(size)).intValue(), "\n");
        }
        if (QLog.isColorLevel()) {
            QLog.d("ConverterSpannedToRichText", 2, "after prepareSpannableString spanned:", spannableStringBuilder.toString());
        }
        return spannableStringBuilder;
    }

    public d a(SpannableStringBuilder spannableStringBuilder) {
        d dVar = new d();
        if (spannableStringBuilder == null) {
            return dVar;
        }
        SpannableStringBuilder d16 = d(spannableStringBuilder);
        String spannableStringBuilder2 = d16.toString();
        if (QLog.isColorLevel()) {
            QLog.d("ConverterSpannedToRichText", 2, "converter spanString:", spannableStringBuilder2);
        }
        Matcher matcher = f447818b.matcher(spannableStringBuilder2);
        int length = spannableStringBuilder2.length();
        boolean z16 = false;
        int i3 = 0;
        int i16 = 0;
        while (matcher.find()) {
            int start = matcher.start();
            length = start;
            b(dVar, i16, length, d16, spannableStringBuilder2);
            this.f447819a++;
            QLog.d("ConverterSpannedToRichText", 2, "converter find startIndex:", Integer.valueOf(i16), "endIndex:", Integer.valueOf(start));
            i3 = matcher.end();
            i16 = i3;
            z16 = true;
        }
        if (!z16) {
            b(dVar, i16, length, d16, spannableStringBuilder2);
        } else if (i3 < d16.length()) {
            b(dVar, i3, d16.length(), d16, spannableStringBuilder2);
        }
        return dVar;
    }
}

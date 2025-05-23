package rn2;

import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.s;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.search.api.IQQSearchApi;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.SearchHitInfo;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a*\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0001\u001a*\u0010\b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0001\u001a*\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0001\u001a\u001a\u0010\r\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n\u001a&\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u000e*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n\u001a\u001e\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n\u001a\u001e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n\u001a0\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0018\u001a\u00020\n2\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003\u001a6\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\n2\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003\u001a&\u0010#\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u00012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0002\u00a8\u0006$"}, d2 = {"Landroid/text/SpannableStringBuilder;", "", "text", "", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchHitInfo;", "hits", "keyword", "d", "b", "a", "", "startIndex", "endIndex", "l", "Lkotlin/Pair;", "k", "currentIndex", "offset", "f", ReportConstant.COSTREPORT_PREFIX, "currentIdx", "previousCount", "g", "originMessage", "maxLen", "subKeyWords", "", tl.h.F, "Lcom/tencent/common/app/AppInterface;", "app", "title", "j", "originText", "originTextLowerCase", "heightLightWords", "e", "qqsearch-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class l {
    /* JADX WARN: Code restructure failed: missing block: B:7:0x004a, code lost:
    
        if (r0 != false) goto L35;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e6  */
    /* JADX WARN: Type inference failed for: r0v14, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v25, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r6v2, types: [T, java.util.Collection, java.util.ArrayList] */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final SpannableStringBuilder a(@NotNull SpannableStringBuilder spannableStringBuilder, @NotNull String text, @NotNull List<SearchHitInfo> hits, @NotNull String keyword) {
        ?? emptyList;
        boolean z16;
        String str;
        String str2;
        int collectionSizeOrDefault;
        Object firstOrNull;
        boolean z17;
        boolean z18;
        Object m476constructorimpl;
        List emptyList2;
        boolean contains$default;
        String str3 = "";
        Intrinsics.checkNotNullParameter(spannableStringBuilder, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(hits, "hits");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        objectRef.element = emptyList;
        boolean z19 = false;
        if (keyword.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Object obj = null;
        if (z16) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) text, (CharSequence) keyword, false, 2, (Object) null);
        }
        if (!hits.isEmpty()) {
            try {
                Result.Companion companion = Result.INSTANCE;
                List<SearchHitInfo> list = hits;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ?? arrayList = new ArrayList(collectionSizeOrDefault);
                for (SearchHitInfo searchHitInfo : list) {
                    arrayList.add(l(text, searchHitInfo.start, searchHitInfo.end));
                }
                objectRef.element = arrayList;
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
                String str4 = (String) firstOrNull;
                if (str4 == null) {
                    str4 = "";
                }
                str = Result.m476constructorimpl(str4);
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                str = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(str);
            if (m479exceptionOrNullimpl == null) {
                str3 = str;
            } else {
                s.e("SearchUtils", "appendDescription: " + text + "(" + keyword + ") " + hits, m479exceptionOrNullimpl);
            }
            str2 = str3;
            if (str2.length() <= 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (!z18) {
                try {
                    Result.Companion companion3 = Result.INSTANCE;
                    Object obj2 = objectRef.element;
                    if (((List) obj2).size() > 1) {
                        z19 = true;
                    }
                    if (z19) {
                        obj = obj2;
                    }
                    List list2 = (List) obj;
                    if (list2 == null || (emptyList2 = list2.subList(1, ((List) objectRef.element).size())) == null) {
                        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                    }
                    m476constructorimpl = Result.m476constructorimpl(i(text, str2, 0, emptyList2, 4, null));
                } catch (Throwable th6) {
                    Result.Companion companion4 = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th6));
                }
                Throwable m479exceptionOrNullimpl2 = Result.m479exceptionOrNullimpl(m476constructorimpl);
                if (m479exceptionOrNullimpl2 != null) {
                    s.e("SearchUtils", "getHighLightMatchedMessage exception: " + text + "(" + keyword + ") " + hits, m479exceptionOrNullimpl2);
                    m476constructorimpl = SearchUtils.E(text, str2, 6, true);
                }
                spannableStringBuilder.append((CharSequence) m476constructorimpl);
            } else {
                spannableStringBuilder.append((CharSequence) text);
            }
            return spannableStringBuilder;
        }
        if (keyword.length() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            StringsKt__StringsKt.contains((CharSequence) text, (CharSequence) keyword, true);
        }
        str2 = keyword;
        if (str2.length() <= 0) {
        }
        if (!z18) {
        }
        return spannableStringBuilder;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0046, code lost:
    
        if (r0 != false) goto L35;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00f7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00f4  */
    /* JADX WARN: Type inference failed for: r0v14, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v25, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r7v2, types: [T, java.util.Collection, java.util.ArrayList] */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final SpannableStringBuilder b(@NotNull SpannableStringBuilder spannableStringBuilder, @NotNull String text, @NotNull List<SearchHitInfo> hits, @NotNull String keyword) {
        ?? emptyList;
        boolean z16;
        String str;
        String str2;
        int collectionSizeOrDefault;
        Object firstOrNull;
        boolean z17;
        boolean z18;
        Object m476constructorimpl;
        List emptyList2;
        boolean contains$default;
        String str3 = "";
        Intrinsics.checkNotNullParameter(spannableStringBuilder, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(hits, "hits");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        objectRef.element = emptyList;
        boolean z19 = false;
        if (keyword.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Object obj = null;
        if (z16) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) text, (CharSequence) keyword, false, 2, (Object) null);
        }
        if (!hits.isEmpty()) {
            try {
                Result.Companion companion = Result.INSTANCE;
                List<SearchHitInfo> list = hits;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ?? arrayList = new ArrayList(collectionSizeOrDefault);
                for (SearchHitInfo searchHitInfo : list) {
                    arrayList.add(l(text, searchHitInfo.start, searchHitInfo.end));
                }
                objectRef.element = arrayList;
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
                String str4 = (String) firstOrNull;
                if (str4 == null) {
                    str4 = "";
                }
                str = Result.m476constructorimpl(str4);
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                str = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(str);
            if (m479exceptionOrNullimpl == null) {
                str3 = str;
            } else {
                s.e("SearchUtils", "appendSubTitle: " + text + "(" + keyword + ") " + hits, m479exceptionOrNullimpl);
            }
            str2 = str3;
            QRouteApi api = QRoute.api(IQQSearchApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IQQSearchApi::class.java)");
            IQQSearchApi iQQSearchApi = (IQQSearchApi) api;
            if (str2.length() <= 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (!z18) {
                try {
                    Result.Companion companion3 = Result.INSTANCE;
                    Object obj2 = objectRef.element;
                    if (((List) obj2).size() > 1) {
                        z19 = true;
                    }
                    if (z19) {
                        obj = obj2;
                    }
                    List list2 = (List) obj;
                    if (list2 == null || (emptyList2 = list2.subList(1, ((List) objectRef.element).size())) == null) {
                        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                    }
                    m476constructorimpl = Result.m476constructorimpl(i(text, str2, 0, emptyList2, 4, null));
                } catch (Throwable th6) {
                    Result.Companion companion4 = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th6));
                }
                Throwable m479exceptionOrNullimpl2 = Result.m479exceptionOrNullimpl(m476constructorimpl);
                if (m479exceptionOrNullimpl2 != null) {
                    s.e("SpannableStringBuilderExt", "appendSubTitle getHighLightMatchedMessage exception: " + text + "(" + keyword + ") " + hits, m479exceptionOrNullimpl2);
                    m476constructorimpl = iQQSearchApi.getHighLightMatchedMessage(text, str2);
                }
                spannableStringBuilder.append(iQQSearchApi.getMessageWithParenthese((CharSequence) m476constructorimpl));
            } else {
                spannableStringBuilder.append(iQQSearchApi.getMessageWithParenthese(text));
            }
            return spannableStringBuilder;
        }
        if (keyword.length() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            StringsKt__StringsKt.contains((CharSequence) text, (CharSequence) keyword, true);
        }
        str2 = keyword;
        QRouteApi api2 = QRoute.api(IQQSearchApi.class);
        Intrinsics.checkNotNullExpressionValue(api2, "api(IQQSearchApi::class.java)");
        IQQSearchApi iQQSearchApi2 = (IQQSearchApi) api2;
        if (str2.length() <= 0) {
        }
        if (!z18) {
        }
        return spannableStringBuilder;
    }

    public static /* synthetic */ SpannableStringBuilder c(SpannableStringBuilder spannableStringBuilder, String str, List list, String str2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str2 = "";
        }
        return b(spannableStringBuilder, str, list, str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x005c, code lost:
    
        if (r0 != false) goto L41;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f8  */
    /* JADX WARN: Type inference failed for: r0v16, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v27, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r14v1, types: [T, java.util.Collection, java.util.ArrayList] */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final SpannableStringBuilder d(@NotNull SpannableStringBuilder spannableStringBuilder, @NotNull String text, @NotNull List<SearchHitInfo> hits, @NotNull String keyword) {
        AppInterface appInterface;
        ?? emptyList;
        boolean z16;
        String str;
        String str2;
        int collectionSizeOrDefault;
        Object firstOrNull;
        boolean z17;
        boolean z18;
        Object m476constructorimpl;
        Object obj;
        List emptyList2;
        boolean contains$default;
        String str3 = "";
        Intrinsics.checkNotNullParameter(spannableStringBuilder, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(hits, "hits");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface == null) {
            return spannableStringBuilder;
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        objectRef.element = emptyList;
        boolean z19 = false;
        if (keyword.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) text, (CharSequence) keyword, false, 2, (Object) null);
        }
        if (!hits.isEmpty()) {
            try {
                Result.Companion companion = Result.INSTANCE;
                List<SearchHitInfo> list = hits;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ?? arrayList = new ArrayList(collectionSizeOrDefault);
                for (SearchHitInfo searchHitInfo : list) {
                    arrayList.add(l(text, searchHitInfo.start, searchHitInfo.end));
                }
                objectRef.element = arrayList;
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
                String str4 = (String) firstOrNull;
                if (str4 == null) {
                    str4 = "";
                }
                str = Result.m476constructorimpl(str4);
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                str = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(str);
            if (m479exceptionOrNullimpl == null) {
                str3 = str;
            } else {
                s.e("SearchUtils", "appendTitle: " + text + "(" + keyword + ") " + hits, m479exceptionOrNullimpl);
            }
            str2 = str3;
            if (str2.length() <= 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (!z18) {
                try {
                    Result.Companion companion3 = Result.INSTANCE;
                    Object obj2 = objectRef.element;
                    if (((List) obj2).size() > 1) {
                        z19 = true;
                    }
                    if (z19) {
                        obj = obj2;
                    } else {
                        obj = null;
                    }
                    List list2 = (List) obj;
                    if (list2 == null || (emptyList2 = list2.subList(1, ((List) objectRef.element).size())) == null) {
                        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                    }
                    m476constructorimpl = Result.m476constructorimpl(j(appInterface, text, str2, 6, emptyList2));
                } catch (Throwable th6) {
                    Result.Companion companion4 = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th6));
                }
                Throwable m479exceptionOrNullimpl2 = Result.m479exceptionOrNullimpl(m476constructorimpl);
                if (m479exceptionOrNullimpl2 != null) {
                    s.e("SearchUtils", "getHighLightMatchedMessageForMainTitle exception: " + text + "(" + keyword + ") " + hits, m479exceptionOrNullimpl2);
                    QRouteApi api = QRoute.api(IQQSearchApi.class);
                    Intrinsics.checkNotNullExpressionValue(api, "api(IQQSearchApi::class.java)");
                    m476constructorimpl = ((IQQSearchApi) api).getHighLightMatchedMessageForMainTitle(appInterface, text, str2);
                }
                spannableStringBuilder.append((CharSequence) m476constructorimpl);
            } else {
                spannableStringBuilder.append((CharSequence) text);
            }
            return spannableStringBuilder;
        }
        if (keyword.length() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            StringsKt__StringsKt.contains((CharSequence) text, (CharSequence) keyword, true);
        }
        str2 = keyword;
        if (str2.length() <= 0) {
        }
        if (!z18) {
        }
        return spannableStringBuilder;
    }

    private static final CharSequence e(String str, String str2, List<String> list) {
        int indexOf$default;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        for (String str3 : list) {
            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str2, str3, 0, true, 2, (Object) null);
            int length = str3.length();
            int a16 = com.tencent.mobileqq.search.util.a.a();
            while (indexOf$default >= 0) {
                int i3 = indexOf$default + length;
                spannableStringBuilder.setSpan(new ForegroundColorSpan(a16), indexOf$default, i3, 17);
                indexOf$default = StringsKt__StringsKt.indexOf((CharSequence) str2, str3, i3, true);
            }
        }
        return spannableStringBuilder;
    }

    @NotNull
    public static final String f(@NotNull String text, int i3, int i16) {
        String str;
        Intrinsics.checkNotNullParameter(text, "text");
        BreakIterator characterInstance = BreakIterator.getCharacterInstance();
        characterInstance.setText(text);
        int i17 = 0;
        int i18 = 0;
        while (true) {
            if (i18 < i16) {
                i18++;
                i3 = characterInstance.preceding(i3);
                if (i3 < 0) {
                    break;
                }
            } else {
                i17 = i3;
                break;
            }
        }
        if (i18 == i16 && i17 > 0) {
            str = "\u2026";
        } else {
            str = "";
        }
        String substring = text.substring(i17, text.length());
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        return str + substring;
    }

    public static final int g(@NotNull String s16, int i3, int i16) {
        boolean z16;
        Intrinsics.checkNotNullParameter(s16, "s");
        boolean z17 = true;
        if (i3 >= 0 && i3 < s16.length()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (i16 < 0) {
                z17 = false;
            }
            if (z17) {
                BreakIterator characterInstance = BreakIterator.getCharacterInstance();
                characterInstance.setText(s16);
                int i17 = 0;
                while (i17 < i16) {
                    i17++;
                    i3 = characterInstance.preceding(i3);
                    if (i3 < 0) {
                        return 0;
                    }
                }
                return i3;
            }
            throw new IllegalArgumentException("n must be non-negative".toString());
        }
        throw new IllegalArgumentException("Index out of bounds".toString());
    }

    @NotNull
    public static final CharSequence h(@NotNull String originMessage, @NotNull String keyword, int i3, @NotNull List<String> subKeyWords) {
        int indexOf$default;
        List plus;
        Intrinsics.checkNotNullParameter(originMessage, "originMessage");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(subKeyWords, "subKeyWords");
        String lowerCase = keyword.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        String lowerCase2 = originMessage.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase()");
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) lowerCase2, lowerCase, 0, false, 6, (Object) null);
        if (indexOf$default >= 0) {
            if (indexOf$default > i3 || (indexOf$default > 4 && lowerCase.length() + indexOf$default > i3)) {
                originMessage = f(originMessage, indexOf$default, 6).toLowerCase();
                Intrinsics.checkNotNullExpressionValue(originMessage, "this as java.lang.String).toLowerCase()");
                lowerCase2 = originMessage.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase()");
            }
        } else if (QLog.isDebugVersion()) {
            QLog.e("SpannableStringBuilderExt", 1, " getHighLightMatchedMessage failed,message = [" + originMessage + "], keyword = [" + lowerCase + "]]");
        }
        plus = CollectionsKt___CollectionsKt.plus((Collection<? extends String>) ((Collection<? extends Object>) subKeyWords), lowerCase);
        return e(originMessage, lowerCase2, plus);
    }

    public static /* synthetic */ CharSequence i(String str, String str2, int i3, List list, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 6;
        }
        if ((i16 & 8) != 0) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        return h(str, str2, i3, list);
    }

    @NotNull
    public static final CharSequence j(@NotNull AppInterface app, @NotNull String title, @NotNull String keyword, int i3, @NotNull List<String> subKeyWords) {
        int indexOf$default;
        List plus;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(subKeyWords, "subKeyWords");
        String lowerCase = keyword.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        Paint paint = SearchUtils.f284962k;
        if (paint == null) {
            View inflate = LayoutInflater.from(app.getApp()).inflate(R.layout.bxl, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026esult_item_contact, null)");
            View findViewById = inflate.findViewById(R.id.title);
            Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) findViewById;
            SearchUtils.f284962k = textView.getPaint();
            if (SearchUtils.f284961j == 0) {
                SearchUtils.f284961j = app.getApp().getResources().getDimensionPixelOffset(R.dimen.aj_);
            }
            paint = textView.getPaint();
        }
        Paint paint2 = paint;
        if (paint2 == null) {
            QLog.e("SpannableStringBuilderExt", 1, "the titleView.paint is null");
            return new SpannableStringBuilder(title);
        }
        String lowerCase2 = title.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase()");
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) lowerCase2, lowerCase, 0, false, 6, (Object) null);
        if (indexOf$default < 0) {
            return title;
        }
        float measureText = paint2.measureText(title);
        float measureText2 = paint2.measureText(lowerCase);
        if (measureText >= SearchUtils.f284961j && indexOf$default > 0) {
            String str = "\u2026";
            float min = (float) Math.min(measureText2 + (paint2.measureText("\u2026") * 2), measureText);
            int i16 = SearchUtils.f284961j;
            float f16 = i16 - min;
            float f17 = 0.0f;
            if (f16 <= 0.0f) {
                QLog.d("SpannableStringBuilderExt", 1, "cutOffMaxsize:  incorrect," + i16 + "," + min + " ");
                f(title, indexOf$default, i3);
            } else {
                int i17 = 0;
                String substring = title.substring(0, indexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                int length = substring.length();
                float[] fArr = new float[length];
                paint2.getTextWidths(substring, fArr);
                int g16 = indexOf$default - g(title, indexOf$default, i3);
                int i18 = length - 1;
                if (i18 >= 0) {
                    while (true) {
                        int i19 = i18 - 1;
                        i17++;
                        f17 += fArr[i18];
                        if (f17 > f16 || i17 >= g16) {
                            break;
                        }
                        if (i19 < 0) {
                            break;
                        }
                        i18 = i19;
                    }
                    int i26 = indexOf$default - i17;
                    if (i26 == 0) {
                        str = "";
                    }
                    String substring2 = title.substring(i26);
                    Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                    String substring3 = lowerCase2.substring(i26);
                    Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String).substring(startIndex)");
                    lowerCase2 = str + substring3;
                    title = str + substring2;
                }
            }
        }
        plus = CollectionsKt___CollectionsKt.plus((Collection<? extends String>) ((Collection<? extends Object>) subKeyWords), lowerCase);
        return e(title, lowerCase2, plus);
    }

    @NotNull
    public static final Pair<Integer, Integer> k(@NotNull String str, int i3, int i16) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        int offsetByCodePoints = str.offsetByCodePoints(0, i3);
        return TuplesKt.to(Integer.valueOf(offsetByCodePoints), Integer.valueOf(str.offsetByCodePoints(offsetByCodePoints, i16 - i3)));
    }

    @NotNull
    public static final String l(@NotNull String str, int i3, int i16) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        int offsetByCodePoints = str.offsetByCodePoints(0, i3);
        String substring = str.substring(offsetByCodePoints, str.offsetByCodePoints(offsetByCodePoints, i16 - i3));
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        return substring;
    }
}

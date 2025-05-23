package yl1;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.cg;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.page.VideoReportPageInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProFeedEntry;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b+\u0010,J)\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\n\u0010\r\u001a\u00020\f*\u00020\u0006J\f\u0010\u000e\u001a\u00020\u0006*\u00020\fH\u0007J\n\u0010\u000f\u001a\u00020\u0006*\u00020\fJ\n\u0010\u0010\u001a\u00020\u0006*\u00020\fJ\u0015\u0010\u0012\u001a\u00020\u0006*\u00020\f2\u0006\u0010\u0011\u001a\u00020\fH\u0086\u0004Jg\u0010\u001e\u001a\u00020\u001c*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\f2K\u0010\u001d\u001aG\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c0\u0016J\u0012\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0 *\u00020\u001fJB\u0010&\u001a\u00020\u001f*\u00020\u001f26\u0010%\u001a2\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110!\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00060#J\n\u0010'\u001a\u00020\u0006*\u00020\u001fR\u0015\u0010*\u001a\u00020\u0006*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lyl1/i;", "", "", "guildId", "feedId", "channelId", "", "d", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Boolean;", "", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProFeedEntry;", "f", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "k", "j", "bit", "g", "", "start", "endExclusive", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "index", "code", "charCount", "", "block", "c", "Lorg/json/JSONArray;", "Lkotlin/sequences/Sequence;", "Lorg/json/JSONObject;", "a", "Lkotlin/Function2;", "jsonObject", "predicate", "b", tl.h.F, "i", "(Ljava/lang/String;)Z", "isQQRuleUrl", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f450608a = new i();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"kotlin/sequences/SequencesKt__SequencesKt$Sequence$1", "Lkotlin/sequences/Sequence;", "", "iterator", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements Sequence<JSONObject> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONArray f450609a;

        public a(JSONArray jSONArray) {
            this.f450609a = jSONArray;
        }

        @Override // kotlin.sequences.Sequence
        @NotNull
        public Iterator<JSONObject> iterator() {
            return new b(this.f450609a);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\t\u0010\u0004\u001a\u00020\u0003H\u0096\u0002J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0096\u0002R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\b\u00a8\u0006\f"}, d2 = {"yl1/i$b", "", "Lorg/json/JSONObject;", "", "hasNext", "a", "", "d", "I", "cursor", "e", "limit", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements Iterator<JSONObject>, KMappedMarker {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int cursor;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int limit;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ JSONArray f450612f;

        b(JSONArray jSONArray) {
            this.f450612f = jSONArray;
            this.limit = jSONArray.length();
        }

        @Override // java.util.Iterator
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public JSONObject next() {
            int i3 = this.cursor;
            if (i3 < this.limit) {
                this.cursor = i3 + 1;
                return this.f450612f.optJSONObject(i3);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.cursor < this.limit) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    i() {
    }

    public static /* synthetic */ Boolean e(i iVar, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str3 = "";
        }
        return iVar.d(str, str2, str3);
    }

    @NotNull
    public final Sequence<JSONObject> a(@NotNull JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        return new a(jSONArray);
    }

    @NotNull
    public final JSONArray b(@NotNull JSONArray jSONArray, @NotNull Function2<? super Integer, ? super JSONObject, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        JSONArray jSONArray2 = new JSONArray();
        int i3 = 0;
        for (JSONObject jSONObject : a(jSONArray)) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            JSONObject jSONObject2 = jSONObject;
            if (jSONObject2 != null && predicate.invoke(Integer.valueOf(i3), jSONObject2).booleanValue()) {
                jSONArray2.mo162put(jSONObject2);
            }
            i3 = i16;
        }
        return jSONArray2;
    }

    public final void c(@NotNull CharSequence charSequence, int i3, int i16, @NotNull Function3<? super Integer, ? super Integer, ? super Integer, Unit> block) {
        int coerceAtMost;
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            Result.Companion companion = Result.INSTANCE;
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(i16, charSequence.length());
            while (i3 < coerceAtMost) {
                int i17 = i3 + 1;
                char charAt = charSequence.charAt(i3);
                if (Character.isHighSurrogate(charAt) && i17 < coerceAtMost) {
                    char charAt2 = charSequence.charAt(i17);
                    if (Character.isLowSurrogate(charAt2)) {
                        block.invoke(Integer.valueOf(i17), Integer.valueOf(Character.toCodePoint(charAt, charAt2)), 2);
                        i3 = i17 + 1;
                    } else {
                        block.invoke(Integer.valueOf(i17 - 1), Integer.valueOf(charAt), 1);
                        i3 = i17;
                    }
                }
                block.invoke(Integer.valueOf(i17 - 1), Integer.valueOf(charAt), 1);
                i3 = i17;
            }
            Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
    }

    @Nullable
    public final Boolean d(@NotNull String guildId, @NotNull String feedId, @NotNull String channelId) {
        String str;
        Pair<Long, Boolean> pair;
        com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.j jVar;
        UIStateData<List<ij1.h>> value;
        List<ij1.h> data;
        String str2;
        long j3;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        com.tencent.mobileqq.guild.feed.morepanel.cooperate.k kVar = (com.tencent.mobileqq.guild.feed.morepanel.cooperate.k) jj1.b.c().getData("GuildFeedTempDataStore", "entry_local_feeds_top_by_self");
        if (Intrinsics.areEqual(channelId, "")) {
            str = feedId;
        } else {
            str = channelId + "_" + feedId;
        }
        if (kVar != null) {
            pair = kVar.d(str);
        } else {
            pair = null;
        }
        IDataDisplaySurface displaySurface = jj1.b.c().getDisplaySurface(ij1.h.class, jj1.b.d(guildId, channelId));
        if (displaySurface instanceof com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.j) {
            jVar = (com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.j) displaySurface;
        } else {
            jVar = null;
        }
        long j16 = 0;
        if (pair != null) {
            long longValue = pair.getFirst().longValue();
            if (jVar != null) {
                j3 = jVar.getLastUpdatedTime();
            } else {
                j3 = 0;
            }
            if (longValue > j3) {
                return pair.getSecond();
            }
        }
        if (jVar == null) {
            return null;
        }
        long lastUpdatedTime = jVar.getLastUpdatedTime();
        if (pair != null) {
            j16 = pair.getFirst().longValue();
        }
        if (lastUpdatedTime <= j16) {
            return null;
        }
        if (kVar != null) {
            kVar.c(str);
        }
        boolean z16 = false;
        MutableLiveData<UIStateData<List<ij1.h>>> displaySurfaceData = jVar.getDisplaySurfaceData(new Object[0]);
        if (displaySurfaceData == null || (value = displaySurfaceData.getValue()) == null || (data = value.getData()) == null) {
            return null;
        }
        List<ij1.h> list = data;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ij1.h hVar = (ij1.h) it.next();
                if (hVar != null) {
                    str2 = hVar.f407814h;
                } else {
                    str2 = null;
                }
                if (Intrinsics.areEqual(str2, feedId)) {
                    z16 = true;
                    break;
                }
            }
        }
        return Boolean.valueOf(z16);
    }

    @NotNull
    public final List<GProFeedEntry> f() {
        String str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(com.tencent.mobileqq.guild.report.b.d());
        VideoReportPageInfo pageInfo = VideoReport.getPageInfo();
        if (pageInfo != null) {
            str = pageInfo.pageId;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str, "VideoReport.getPageInfo()?.pageId ?: \"\"");
        }
        linkedHashMap.put("page_id", str);
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            GProFeedEntry gProFeedEntry = new GProFeedEntry();
            gProFeedEntry.key = (String) entry.getKey();
            gProFeedEntry.value = (String) entry.getValue();
            arrayList.add(gProFeedEntry);
        }
        return arrayList;
    }

    public final boolean g(int i3, int i16) {
        if ((i3 & i16) != 0) {
            return true;
        }
        return false;
    }

    public final boolean h(@NotNull JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        if (jSONArray.length() <= 0) {
            return true;
        }
        return false;
    }

    public final boolean i(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (!cg.f307524c.matcher(str).find() && !cg.f307525d.matcher(str).find()) {
            return false;
        }
        return true;
    }

    public final boolean j(int i3) {
        return !k(i3);
    }

    public final boolean k(int i3) {
        if (i3 != 0) {
            return true;
        }
        return false;
    }

    @Deprecated(message = "yesOrNo\u8bed\u4e49\u4e0d\u660e\u786e, \u5230\u5e95\u662fyes\u8fd8\u662fno\u5462?", replaceWith = @ReplaceWith(expression = "yes()", imports = {}))
    public final boolean l(int i3) {
        return k(i3);
    }

    public final int m(boolean z16) {
        return z16 ? 1 : 0;
    }
}

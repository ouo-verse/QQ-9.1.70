package rp2;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007\u00a8\u0006\b"}, d2 = {"Lrp2/c;", "", "<init>", "()V", "a", "b", "Lrp2/c$a;", "Lrp2/c$b;", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public abstract class c {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lrp2/c$a;", "Lrp2/c;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "a", "J", "()J", "id", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "keyWord", "<init>", "(JLjava/lang/String;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: rp2.c$a, reason: from toString */
    /* loaded from: classes18.dex */
    public static final /* data */ class SearchHistoryKeywordData extends c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final long id;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String keyWord;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SearchHistoryKeywordData(long j3, @NotNull String keyWord) {
            super(null);
            Intrinsics.checkNotNullParameter(keyWord, "keyWord");
            this.id = j3;
            this.keyWord = keyWord;
        }

        /* renamed from: a, reason: from getter */
        public final long getId() {
            return this.id;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getKeyWord() {
            return this.keyWord;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SearchHistoryKeywordData)) {
                return false;
            }
            SearchHistoryKeywordData searchHistoryKeywordData = (SearchHistoryKeywordData) other;
            if (this.id == searchHistoryKeywordData.id && Intrinsics.areEqual(this.keyWord, searchHistoryKeywordData.keyWord)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (androidx.fragment.app.a.a(this.id) * 31) + this.keyWord.hashCode();
        }

        @NotNull
        public String toString() {
            return "SearchHistoryKeywordData(id=" + this.id + ", keyWord=" + this.keyWord + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0016\u001a\u00020\f\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\f\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010 \u001a\u00020\u0002\u00a2\u0006\u0004\b*\u0010+J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002J\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\tJ\t\u0010\u000b\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\r\u001a\u00020\fH\u00d6\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u00d6\u0003R\u0017\u0010\u0016\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001d\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u0015R\u0017\u0010\u001e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u0017\u0010 \u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u001f\u0010\u0019R\"\u0010%\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010!\u001a\u0004\b\u0012\u0010\"\"\u0004\b#\u0010$R\u0017\u0010)\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010&\u001a\u0004\b'\u0010(\u00a8\u0006,"}, d2 = {"Lrp2/c$b;", "Lrp2/c;", "", "e", "i", "Lorg/json/JSONObject;", h.F, "key", "d", "", "k", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "b", "()I", "id", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "sugWord", "c", "g", "sugWordType", "queryKeyword", "getTransInfo", "transInfo", "Z", "()Z", "j", "(Z)V", "hasReportWXImpl", "Lorg/json/JSONObject;", "getJsonExtention", "()Lorg/json/JSONObject;", "jsonExtention", "<init>", "(ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: rp2.c$b, reason: from toString */
    /* loaded from: classes18.dex */
    public static final /* data */ class SearchSuggestKeywordData extends c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int id;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String sugWord;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int sugWordType;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String queryKeyword;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String transInfo;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private boolean hasReportWXImpl;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final JSONObject jsonExtention;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SearchSuggestKeywordData(int i3, @NotNull String sugWord, int i16, @NotNull String queryKeyword, @NotNull String transInfo) {
            super(null);
            JSONObject jSONObject;
            Intrinsics.checkNotNullParameter(sugWord, "sugWord");
            Intrinsics.checkNotNullParameter(queryKeyword, "queryKeyword");
            Intrinsics.checkNotNullParameter(transInfo, "transInfo");
            this.id = i3;
            this.sugWord = sugWord;
            this.sugWordType = i16;
            this.queryKeyword = queryKeyword;
            this.transInfo = transInfo;
            try {
                jSONObject = new JSONObject(transInfo);
            } catch (Exception unused) {
                jSONObject = new JSONObject();
            }
            this.jsonExtention = jSONObject;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getHasReportWXImpl() {
            return this.hasReportWXImpl;
        }

        /* renamed from: b, reason: from getter */
        public final int getId() {
            return this.id;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getQueryKeyword() {
            return this.queryKeyword;
        }

        @NotNull
        public final String d(@NotNull String key) {
            String obj;
            Intrinsics.checkNotNullParameter(key, "key");
            Object opt = this.jsonExtention.opt(key);
            if (opt == null || (obj = opt.toString()) == null) {
                return "";
            }
            return obj;
        }

        @NotNull
        public final String e() {
            Object opt;
            String obj;
            JSONObject optJSONObject = this.jsonExtention.optJSONObject("trans_info");
            if (optJSONObject == null || (opt = optJSONObject.opt("trace_id")) == null || (obj = opt.toString()) == null) {
                return "";
            }
            return obj;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SearchSuggestKeywordData)) {
                return false;
            }
            SearchSuggestKeywordData searchSuggestKeywordData = (SearchSuggestKeywordData) other;
            if (this.id == searchSuggestKeywordData.id && Intrinsics.areEqual(this.sugWord, searchSuggestKeywordData.sugWord) && this.sugWordType == searchSuggestKeywordData.sugWordType && Intrinsics.areEqual(this.queryKeyword, searchSuggestKeywordData.queryKeyword) && Intrinsics.areEqual(this.transInfo, searchSuggestKeywordData.transInfo)) {
                return true;
            }
            return false;
        }

        @NotNull
        /* renamed from: f, reason: from getter */
        public final String getSugWord() {
            return this.sugWord;
        }

        /* renamed from: g, reason: from getter */
        public final int getSugWordType() {
            return this.sugWordType;
        }

        @NotNull
        public final JSONObject h() {
            JSONObject optJSONObject = this.jsonExtention.optJSONObject("trans_info");
            if (optJSONObject == null) {
                return new JSONObject();
            }
            return optJSONObject;
        }

        public int hashCode() {
            return (((((((this.id * 31) + this.sugWord.hashCode()) * 31) + this.sugWordType) * 31) + this.queryKeyword.hashCode()) * 31) + this.transInfo.hashCode();
        }

        @NotNull
        public final String i() {
            String optString;
            JSONObject optJSONObject = h().optJSONObject("report_data");
            if (optJSONObject == null || (optString = optJSONObject.optString("suggestion_id")) == null) {
                return "";
            }
            Intrinsics.checkNotNullExpressionValue(optString, "reportData.optString(\"suggestion_id\") ?: \"\"");
            return optString;
        }

        public final void j(boolean z16) {
            this.hasReportWXImpl = z16;
        }

        @NotNull
        public final Map<String, String> k() {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator keys = this.jsonExtention.keys();
            while (keys.hasNext()) {
                String key = (String) keys.next();
                Object opt = this.jsonExtention.opt(key);
                if (opt != null) {
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    linkedHashMap.put(key, opt.toString());
                }
            }
            return linkedHashMap;
        }

        @NotNull
        public String toString() {
            return "SearchSuggestKeywordData(id=" + this.id + ", sugWord=" + this.sugWord + ", sugWordType=" + this.sugWordType + ", queryKeyword=" + this.queryKeyword + ", transInfo=" + this.transInfo + ")";
        }
    }

    public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    c() {
    }
}

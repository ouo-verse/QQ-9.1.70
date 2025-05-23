package rj3;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\t\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bX\u0010YJ\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0002J\u0010\u0010\u0011\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u0013\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u0015\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u0017\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u000bJ\"\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u0018j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b`\u0019R(\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR(\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001f\u0010\u001eR(\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0017\u0010\u001c\u001a\u0004\b \u0010\u001eR(\u0010\"\u001a\u0004\u0018\u00010\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b!\u0010\u001eR(\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0004\u0010\u001c\u001a\u0004\b#\u0010\u001eR(\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000b8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u000f\u0010$\u001a\u0004\b%\u0010&R(\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0013\u0010\u001c\u001a\u0004\b'\u0010\u001eR(\u0010)\u001a\u0004\u0018\u00010\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\n\u0010\u001c\u001a\u0004\b(\u0010\u001eR(\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000b8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0011\u0010$\u001a\u0004\b*\u0010&R(\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000b8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0015\u0010$\u001a\u0004\b+\u0010&R(\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000b8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\b\u0010$\u001a\u0004\b,\u0010&R(\u0010/\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000b8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b-\u0010$\u001a\u0004\b.\u0010&R(\u00102\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000b8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b0\u0010$\u001a\u0004\b1\u0010&R(\u00105\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000b8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b3\u0010$\u001a\u0004\b4\u0010&R(\u00108\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000b8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b6\u0010$\u001a\u0004\b7\u0010&R(\u0010;\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000b8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b9\u0010$\u001a\u0004\b:\u0010&R(\u0010>\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000b8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b<\u0010$\u001a\u0004\b=\u0010&R(\u0010A\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000b8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b?\u0010$\u001a\u0004\b@\u0010&R(\u0010D\u001a\u0004\u0018\u00010\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bB\u0010\u001c\u001a\u0004\bC\u0010\u001eR(\u0010J\u001a\u0004\u0018\u00010E2\b\u0010\u001b\u001a\u0004\u0018\u00010E8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR(\u0010M\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000b8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bK\u0010$\u001a\u0004\bL\u0010&R(\u0010P\u001a\u0004\u0018\u00010\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bN\u0010\u001c\u001a\u0004\bO\u0010\u001eR>\u0010W\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u0018j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b`\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010V\u00a8\u0006Z"}, d2 = {"Lrj3/a;", "", "", "mode", "e", "entry", "b", "type", "k", "personNum", h.F, "", "keyText", "d", "ownerStatus", "f", "qqUin", "i", "peerUin", "g", "timestamp", "j", "ex", "c", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "a", "<set-?>", "Ljava/lang/Integer;", "getMode", "()Ljava/lang/Integer;", "getEntry", "getType", "getGuest", QCircleDaTongConstant.ElementParamValue.PROFILE_GUEST_TYPE, "getPersonNum", "Ljava/lang/String;", "getKeyText", "()Ljava/lang/String;", "getOwnerStatus", "getPeerStatus", "peerStatus", "getQqUin", "getPeerUin", "getTimestamp", "l", "getDuration", "duration", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getEx1", "ex1", DomainData.DOMAIN_NAME, "getEx2", "ex2", "o", "getEx3", "ex3", "p", "getEx4", "ex4", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "getEx5", "ex5", "r", "getFromEntrance", "fromEntrance", ReportConstant.COSTREPORT_PREFIX, "getIntimateType", "intimateType", "", "t", "Ljava/lang/Long;", "getIntimateRelationTimestamp", "()Ljava/lang/Long;", "intimateRelationTimestamp", "u", "getExMore", "exMore", "v", "getVip", "vip", "w", "Ljava/util/HashMap;", "getParams", "()Ljava/util/HashMap;", "setParams", "(Ljava/util/HashMap;)V", "params", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer mode;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer entry;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer type;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer guest;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer personNum;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String keyText;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer ownerStatus;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer peerStatus;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String qqUin;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String peerUin;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String timestamp;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String duration;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String ex1;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String ex2;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String ex3;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String ex4;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String ex5;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String fromEntrance;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer intimateType;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Long intimateRelationTimestamp;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String exMore;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer vip;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HashMap<String, String> params = new HashMap<>();

    @NotNull
    public final HashMap<String, String> a() {
        Integer num = this.mode;
        if (num != null) {
            this.params.put("mode", String.valueOf(num));
        }
        Integer num2 = this.entry;
        if (num2 != null) {
            this.params.put("entry", String.valueOf(num2));
        }
        Integer num3 = this.type;
        if (num3 != null) {
            this.params.put("type", String.valueOf(num3));
        }
        Integer num4 = this.guest;
        if (num4 != null) {
            this.params.put(QCircleDaTongConstant.ElementParamValue.PROFILE_GUEST_TYPE, String.valueOf(num4));
        }
        Integer num5 = this.personNum;
        if (num5 != null) {
            this.params.put("personNum", String.valueOf(num5));
        }
        String str = this.keyText;
        if (str != null) {
            this.params.put("keyText", String.valueOf(str));
        }
        Integer num6 = this.ownerStatus;
        if (num6 != null) {
            this.params.put("ownerStatus", String.valueOf(num6));
        }
        Integer num7 = this.peerStatus;
        if (num7 != null) {
            this.params.put("peerStatus", String.valueOf(num7));
        }
        String str2 = this.qqUin;
        if (str2 != null) {
            this.params.put("qqUin", String.valueOf(str2));
        }
        String str3 = this.peerUin;
        if (str3 != null) {
            this.params.put("peerUin", String.valueOf(str3));
        }
        String str4 = this.timestamp;
        if (str4 != null) {
            this.params.put("timestamp", String.valueOf(str4));
        }
        String str5 = this.duration;
        if (str5 != null) {
            this.params.put("duration", String.valueOf(str5));
        }
        String str6 = this.ex1;
        if (str6 != null) {
            this.params.put("ex1", String.valueOf(str6));
        }
        String str7 = this.ex2;
        if (str7 != null) {
            this.params.put("ex2", String.valueOf(str7));
        }
        String str8 = this.ex3;
        if (str8 != null) {
            this.params.put("ex3", String.valueOf(str8));
        }
        String str9 = this.ex4;
        if (str9 != null) {
            this.params.put("ex4", String.valueOf(str9));
        }
        String str10 = this.ex5;
        if (str10 != null) {
            this.params.put("ex5", String.valueOf(str10));
        }
        String str11 = this.fromEntrance;
        if (str11 != null) {
            this.params.put("from_entrance", String.valueOf(str11));
        }
        Integer num8 = this.intimateType;
        if (num8 != null) {
            this.params.put("intimateRelation", String.valueOf(num8));
        }
        Long l3 = this.intimateRelationTimestamp;
        if (l3 != null) {
            this.params.put("intimateRelationTimeStamp", String.valueOf(l3));
        }
        String str12 = this.exMore;
        if (str12 != null) {
            this.params.put("exMore", String.valueOf(str12));
        }
        Integer num9 = this.vip;
        if (num9 != null) {
            this.params.put("vip", String.valueOf(num9));
        }
        return this.params;
    }

    @NotNull
    public final a b(int entry) {
        this.entry = Integer.valueOf(entry);
        return this;
    }

    @NotNull
    public final a c(@Nullable String ex5) {
        this.ex1 = ex5;
        return this;
    }

    @NotNull
    public final a d(@NotNull String keyText) {
        Intrinsics.checkNotNullParameter(keyText, "keyText");
        this.keyText = keyText;
        return this;
    }

    @NotNull
    public final a e(int mode) {
        this.mode = Integer.valueOf(mode);
        return this;
    }

    @NotNull
    public final a f(int ownerStatus) {
        this.ownerStatus = Integer.valueOf(ownerStatus);
        return this;
    }

    @NotNull
    public final a g(@Nullable String peerUin) {
        this.peerUin = peerUin;
        return this;
    }

    @NotNull
    public final a h(int personNum) {
        this.personNum = Integer.valueOf(personNum);
        return this;
    }

    @NotNull
    public final a i(@Nullable String qqUin) {
        this.qqUin = qqUin;
        return this;
    }

    @NotNull
    public final a j(@Nullable String timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    @NotNull
    public final a k(int type) {
        this.type = Integer.valueOf(type);
        return this;
    }
}

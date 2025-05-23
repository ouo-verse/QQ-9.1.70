package zl1;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import yl1.i;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b \n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\"\u001e\u0010\u0006\u001a\u00020\u0001*\u00020\u00008FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003\"(\u0010\r\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\"(\u0010\u0011\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000e\u0010\u0003\"\u0004\b\u000f\u0010\u0010\"(\u0010\u0014\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0012\u0010\u0003\"\u0004\b\u0013\u0010\u0010\"(\u0010\u0017\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0015\u0010\u0003\"\u0004\b\u0016\u0010\u0010\"(\u0010\u001a\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0018\u0010\u0003\"\u0004\b\u0019\u0010\u0010\"\u001e\u0010\u001d\u001a\u00020\u0007*\u00020\u00008FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u001c\u0010\u0005\u001a\u0004\b\u001b\u0010\n\"\u0015\u0010\u001f\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u0003\"\u0015\u0010!\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b \u0010\u0003\"\u0015\u0010#\u001a\u00020\u0007*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\"\u0010\n\".\u0010'\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00078F@FX\u0087\u000e\u00a2\u0006\u0012\u0012\u0004\b&\u0010\u0005\u001a\u0004\b$\u0010\n\"\u0004\b%\u0010\f\"\u0017\u0010+\u001a\u0004\u0018\u00010(*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b)\u0010*\"\u0017\u0010/\u001a\u0004\u0018\u00010,*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b-\u0010.\"\u0015\u00101\u001a\u00020\u0007*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b0\u0010\n\"\u0015\u00103\u001a\u00020,*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b2\u0010.\u00a8\u00064"}, d2 = {"Lzl1/a;", "", "j", "(Lzl1/a;)Z", "isGlobalSceneEditor$annotations", "(Lzl1/a;)V", "isGlobalSceneEditor", "", "value", "l", "(Lzl1/a;)I", "p", "(Lzl1/a;I)V", "isPartNotSelected", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "setPersonalGuildToBeCreated", "(Lzl1/a;Z)V", "isPersonalGuildToBeCreated", "k", "setGuildSelected", "isGuildSelected", "i", "setForceChannelSelected", "isForceChannelSelected", h.F, "setCanOpenPartPanel", "isCanOpenPartPanel", "c", "getPreviousPageBusinessType$annotations", "previousPageBusinessType", "o", "isTroopGuild", DomainData.DOMAIN_NAME, "isTopic", "b", "draftTypeMatched", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "getTempBusinessTypeFromPartType$annotations", "tempBusinessTypeFromPartType", "", "f", "(Lzl1/a;)Ljava/lang/Long;", "topicIdCarried", "", "g", "(Lzl1/a;)Ljava/lang/String;", "topicNameCarried", "d", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "a", "draftId", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {
    @NotNull
    public static final String a(@NotNull a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        if (j(aVar)) {
            return "";
        }
        return aVar.h();
    }

    public static final int b(@NotNull a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        if (n(aVar)) {
            return 3;
        }
        if (!TextUtils.isEmpty(aVar.getDraftKey())) {
            return 4;
        }
        if (o(aVar)) {
            return 10;
        }
        return 1;
    }

    public static final int c(@NotNull a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        return aVar.getExtra().getInt("feed_card_page_source", 0);
    }

    public static final int d(@NotNull a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        return aVar.getExtra().getInt("launch_request_id");
    }

    public static final int e(@NotNull a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        return aVar.getExtra().getInt("feed_publish_param_extra_temp_business_type");
    }

    @Nullable
    public static final Long f(@NotNull a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Bundle bundle = aVar.getExtra().getBundle("topic_element_append");
        if (bundle != null) {
            return Long.valueOf(bundle.getLong("topic_id"));
        }
        return null;
    }

    @Nullable
    public static final String g(@NotNull a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Bundle bundle = aVar.getExtra().getBundle("topic_element_append");
        if (bundle != null) {
            return bundle.getString("topic_name");
        }
        return null;
    }

    public static final boolean h(@NotNull a aVar) {
        int i3;
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        i iVar = i.f450608a;
        Integer num = aVar.getContact().getTags().get("is_can_open_part_panel");
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = 1;
        }
        return iVar.l(i3);
    }

    public static final boolean i(@NotNull a aVar) {
        int i3;
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        i iVar = i.f450608a;
        Integer num = aVar.getContact().getTags().get("is_force_part_selected");
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = 0;
        }
        return iVar.l(i3);
    }

    public static final boolean j(@NotNull a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        if (aVar.getSceneType() == 6) {
            return true;
        }
        return false;
    }

    public static final boolean k(@NotNull a aVar) {
        int i3;
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        i iVar = i.f450608a;
        Integer num = aVar.getContact().getTags().get("is_guild_selected");
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = 0;
        }
        return iVar.l(i3);
    }

    public static final int l(@NotNull a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Integer num = aVar.getContact().getTags().get("is_part_not_selected");
        if (num != null) {
            return num.intValue();
        }
        return 1;
    }

    public static final boolean m(@NotNull a aVar) {
        int i3;
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        i iVar = i.f450608a;
        Integer num = aVar.getContact().getTags().get("is_personal_guild_to_be_created");
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = 0;
        }
        return iVar.l(i3);
    }

    public static final boolean n(@NotNull a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        if (c(aVar) == 20) {
            return true;
        }
        return false;
    }

    public static final boolean o(@NotNull a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        if (c(aVar) == 7) {
            return true;
        }
        return false;
    }

    public static final void p(@NotNull a aVar, int i3) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        aVar.getContact().getTags().put("is_part_not_selected", Integer.valueOf(i3));
    }

    public static final void q(@NotNull a aVar, int i3) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        aVar.getExtra().putInt("feed_publish_param_extra_temp_business_type", i3);
    }
}

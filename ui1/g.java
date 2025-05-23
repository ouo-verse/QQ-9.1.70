package ui1;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelShareInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelSign;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStIconInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStNotice;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStNoticePattonInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStPlainTxtInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStShare;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStUser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u0006\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u0007\u001a\u00020\u0003*\u00020\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStNotice;", "", "e", "", "b", "a", "d", "c", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class g {
    @NotNull
    public static final String a(@NotNull GProStNotice gProStNotice) {
        long j3;
        GProStShare gProStShare;
        GProStChannelShareInfo gProStChannelShareInfo;
        GProStChannelSign gProStChannelSign;
        Intrinsics.checkNotNullParameter(gProStNotice, "<this>");
        GProStFeed gProStFeed = gProStNotice.origineFeed;
        if (gProStFeed != null && (gProStShare = gProStFeed.share) != null && (gProStChannelShareInfo = gProStShare.channelShareInfo) != null && (gProStChannelSign = gProStChannelShareInfo.channelSign) != null) {
            j3 = gProStChannelSign.channelId;
        } else {
            j3 = 0;
        }
        if (j3 > 0) {
            return String.valueOf(j3);
        }
        return "";
    }

    @NotNull
    public static final String b(@NotNull GProStNotice gProStNotice) {
        long j3;
        GProStShare gProStShare;
        GProStChannelShareInfo gProStChannelShareInfo;
        GProStChannelSign gProStChannelSign;
        Intrinsics.checkNotNullParameter(gProStNotice, "<this>");
        GProStFeed gProStFeed = gProStNotice.origineFeed;
        if (gProStFeed != null && (gProStShare = gProStFeed.share) != null && (gProStChannelShareInfo = gProStShare.channelShareInfo) != null && (gProStChannelSign = gProStChannelShareInfo.channelSign) != null) {
            j3 = gProStChannelSign.guildId;
        } else {
            j3 = 0;
        }
        if (j3 > 0) {
            return String.valueOf(j3);
        }
        return "";
    }

    @NotNull
    public static final String c(@NotNull GProStNotice gProStNotice) {
        String str;
        boolean isBlank;
        GProStUser gProStUser;
        GProStIconInfo gProStIconInfo;
        GProStUser gProStUser2;
        GProStIconInfo gProStIconInfo2;
        Intrinsics.checkNotNullParameter(gProStNotice, "<this>");
        GProStFeed gProStFeed = gProStNotice.psvFeed;
        String str2 = null;
        if (gProStFeed != null && (gProStUser2 = gProStFeed.poster) != null && (gProStIconInfo2 = gProStUser2.icon) != null) {
            str = gProStIconInfo2.iconUrl140;
        } else {
            str = null;
        }
        String str3 = "";
        if (str == null) {
            str = "";
        }
        isBlank = StringsKt__StringsJVMKt.isBlank(str);
        if (isBlank) {
            GProStFeed gProStFeed2 = gProStNotice.psvFeed;
            if (gProStFeed2 != null && (gProStUser = gProStFeed2.poster) != null && (gProStIconInfo = gProStUser.icon) != null) {
                str2 = gProStIconInfo.iconUrl;
            }
            if (str2 != null) {
                str3 = str2;
            }
            return str3;
        }
        return str;
    }

    @NotNull
    public static final String d(@NotNull GProStNotice gProStNotice) {
        long j3;
        Intrinsics.checkNotNullParameter(gProStNotice, "<this>");
        GProStFeed gProStFeed = gProStNotice.origineFeed;
        if (gProStFeed != null) {
            j3 = gProStFeed.groupCode;
        } else {
            j3 = 0;
        }
        if (j3 > 0) {
            return String.valueOf(j3);
        }
        return "";
    }

    public static final boolean e(@NotNull GProStNotice gProStNotice) {
        GProStPlainTxtInfo gProStPlainTxtInfo;
        Intrinsics.checkNotNullParameter(gProStNotice, "<this>");
        GProStNoticePattonInfo gProStNoticePattonInfo = gProStNotice.pattonInfo;
        if (gProStNoticePattonInfo == null || (gProStPlainTxtInfo = gProStNoticePattonInfo.plainTxt) == null || gProStPlainTxtInfo.noticeType != 1) {
            return false;
        }
        return true;
    }
}

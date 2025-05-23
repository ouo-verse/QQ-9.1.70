package t52;

import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper;
import com.tencent.mobileqq.qqvideoplatform.api.PlatformInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0000H\u0002\u001a\n\u0010\u0005\u001a\u00020\u0004*\u00020\u0000\u00a8\u0006\u0006"}, d2 = {"Lt52/f;", "", "c", "b", "Lcom/tencent/superplayer/api/SuperPlayerVideoInfo;", "a", "kandian-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class g {
    @NotNull
    public static final SuperPlayerVideoInfo a(@NotNull PlayerVideoInfo playerVideoInfo) {
        int i3;
        Iterable<IndexedValue> withIndex;
        String str;
        boolean contains$default;
        boolean contains$default2;
        int indexOf$default;
        int indexOf$default2;
        SuperPlayerVideoInfo createVideoInfoForTVideo;
        boolean z16;
        Intrinsics.checkNotNullParameter(playerVideoInfo, "<this>");
        boolean z17 = false;
        if (c(playerVideoInfo) == 1) {
            String pid = playerVideoInfo.getPid();
            if (pid != null) {
                if (pid.length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    z17 = true;
                }
            }
            if (z17) {
                createVideoInfoForTVideo = SuperPlayerFactory.createVideoInfoForTVideo(PlatformInfo.ID_KANDIAN, playerVideoInfo.getVid(), playerVideoInfo.getPid());
            } else {
                createVideoInfoForTVideo = SuperPlayerFactory.createVideoInfoForTVideo(PlatformInfo.ID_KANDIAN, playerVideoInfo.getVid());
            }
            Intrinsics.checkNotNullExpressionValue(createVideoInfoForTVideo, "{\n        // openByVid\n \u2026IAN, vid)\n        }\n    }");
            return createVideoInfoForTVideo;
        }
        int b16 = b(playerVideoInfo);
        String[] urls = playerVideoInfo.getUrls();
        if (urls != null) {
            i3 = urls.length;
        } else {
            i3 = 0;
        }
        String str2 = null;
        if (i3 > 0) {
            String[] urls2 = playerVideoInfo.getUrls();
            if (urls2 != null) {
                str = urls2[0];
            } else {
                str = null;
            }
            if (str != null) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "com/", false, 2, (Object) null);
                if (contains$default) {
                    contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, false, 2, (Object) null);
                    if (contains$default2) {
                        String str3 = str;
                        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str3, "com/", 0, false, 6, (Object) null);
                        indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) str3, QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, 0, false, 6, (Object) null);
                        String substring = str.substring(indexOf$default + 4, indexOf$default2);
                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                        str2 = substring;
                    }
                }
            }
        }
        if (playerVideoInfo.getUrls() != null) {
            withIndex = ArraysKt___ArraysKt.withIndex(playerVideoInfo.getUrls());
            for (IndexedValue indexedValue : withIndex) {
                int index = indexedValue.getIndex();
                String modifyVideoUrlForKingCard = ((IVideoFeedsHelper) QRoute.api(IVideoFeedsHelper.class)).modifyVideoUrlForKingCard((String) indexedValue.component2());
                if (modifyVideoUrlForKingCard != null) {
                    playerVideoInfo.getUrls()[index] = modifyVideoUrlForKingCard;
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("PlayerVideoInfo", 2, "generateSPVideoInfo: vid=" + playerVideoInfo.getVid() + ", fileId=" + str2);
        }
        SuperPlayerVideoInfo createVideoInfoForUrl = SuperPlayerFactory.createVideoInfoForUrl(playerVideoInfo.getUrls(), b16, playerVideoInfo.getDuration(), str2);
        Intrinsics.checkNotNullExpressionValue(createVideoInfoForUrl, "{\n        // openByUrl\n \u2026, duration, fileId)\n    }");
        return createVideoInfoForUrl;
    }

    private static final int b(PlayerVideoInfo playerVideoInfo) {
        int playType = playerVideoInfo.getPlayType();
        if (playType != 3) {
            if (playType != 4) {
                if (playType != 5) {
                    switch (playType) {
                        case 101:
                            break;
                        case 102:
                            break;
                        case 103:
                            break;
                        case 104:
                            return 201;
                        case 105:
                            return 203;
                        default:
                            return 103;
                    }
                }
                return 104;
            }
            return 102;
        }
        return 101;
    }

    private static final int c(PlayerVideoInfo playerVideoInfo) {
        int playType = playerVideoInfo.getPlayType();
        if (playType == 1 || playType == 2) {
            return 1;
        }
        return 2;
    }
}

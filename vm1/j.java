package vm1;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0018\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016\u00a8\u0006\u0019"}, d2 = {"Lvm1/j;", "Lvm1/d;", "Lfm1/i;", QCircleScheme.AttrDetail.VIDEO_INFO, "Lorg/json/JSONObject;", tl.h.F, "Lsk1/b;", "linkSpan", "i", QCircleScheme.AttrDetail.FEED_INFO, "", "g", "f", "mediaInfo", "c", "d", "e", "Lwm1/i;", "wordInfo", "Lnm1/b;", "translateInfo", "b", "a", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class j implements d {
    private final JSONObject c(fm1.i mediaInfo) {
        if (mediaInfo instanceof fm1.b) {
            return mediaInfo.g();
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cover", mediaInfo.getVideoCoverUrl());
        jSONObject.put("duration", mediaInfo.getVideoDuration());
        return jSONObject;
    }

    private final JSONObject d(fm1.i mediaInfo) {
        if (mediaInfo instanceof fm1.f) {
            JSONObject jSONObject = new JSONObject();
            fm1.f fVar = (fm1.f) mediaInfo;
            jSONObject.put("url", fVar.getCoverUrl());
            jSONObject.put("title", fVar.getTitle());
            jSONObject.put("icon", fVar.getIconUrl());
            jSONObject.put("platform_name", fVar.getPlatformName());
            jSONObject.put(QCircleDaTongConstant.ElementParamValue.PERMISSION, fVar.getPermissionDsc());
            return jSONObject;
        }
        return new JSONObject();
    }

    private final JSONObject e(fm1.i mediaInfo) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("icon", "");
        jSONObject.put("name", "");
        return jSONObject;
    }

    private final String f(fm1.i feedInfo) {
        String videoShortPlayUrl;
        String title;
        int urlType = feedInfo.getUrlType();
        fm1.g gVar = null;
        fm1.f fVar = null;
        if (urlType != 1) {
            if (urlType != 3) {
                return "";
            }
            if (feedInfo instanceof fm1.f) {
                fVar = (fm1.f) feedInfo;
            }
            if (fVar == null || (title = fVar.getTitle()) == null) {
                return feedInfo.getVideoPlayUrl();
            }
            return title;
        }
        if (feedInfo instanceof fm1.g) {
            gVar = (fm1.g) feedInfo;
        }
        if (gVar == null || (videoShortPlayUrl = gVar.getVideoShortPlayUrl()) == null) {
            return "";
        }
        return videoShortPlayUrl;
    }

    private final String g(fm1.i feedInfo) {
        fm1.g gVar;
        String videoShortPlayUrl;
        int urlType = feedInfo.getUrlType();
        if (urlType != 1) {
            if (urlType != 3) {
                return "";
            }
            return feedInfo.getVideoPlayUrl();
        }
        if (feedInfo instanceof fm1.g) {
            gVar = (fm1.g) feedInfo;
        } else {
            gVar = null;
        }
        if (gVar == null || (videoShortPlayUrl = gVar.getVideoShortPlayUrl()) == null) {
            return "";
        }
        return videoShortPlayUrl;
    }

    private final JSONObject h(fm1.i videoInfo) {
        String g16 = g(videoInfo);
        int urlType = videoInfo.getUrlType();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", urlType);
        jSONObject.put("url", g16);
        jSONObject.put("displayText", f(videoInfo));
        jSONObject.put("play_url", videoInfo.getVideoPlayUrl());
        jSONObject.put("third_platform", e(videoInfo));
        jSONObject.put("third_video_info", c(videoInfo));
        jSONObject.put("tencent_docs_content", d(videoInfo));
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("type", 3);
        jSONObject2.put("url_content", jSONObject);
        return jSONObject2;
    }

    private final JSONObject i(sk1.b linkSpan) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", 10);
        jSONObject.put("url", linkSpan.getUrl());
        jSONObject.put("displayText", linkSpan.getRenderText());
        jSONObject.put("icon_type", linkSpan.getIconType());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("type", 3);
        jSONObject2.put("url_content", jSONObject);
        return jSONObject2;
    }

    @Override // vm1.d
    @NotNull
    public JSONObject a(@NotNull wm1.i wordInfo, @NotNull nm1.b translateInfo) {
        Intrinsics.checkNotNullParameter(wordInfo, "wordInfo");
        Intrinsics.checkNotNullParameter(translateInfo, "translateInfo");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("text", "");
        jSONObject.put("type", 12);
        jSONObject.put("props", new JSONObject());
        return jSONObject;
    }

    @Override // vm1.d
    @NotNull
    public JSONObject b(@NotNull wm1.i wordInfo, @NotNull nm1.b translateInfo) {
        wm1.f fVar;
        Object first;
        Intrinsics.checkNotNullParameter(wordInfo, "wordInfo");
        Intrinsics.checkNotNullParameter(translateInfo, "translateInfo");
        sk1.b bVar = null;
        if (wordInfo instanceof wm1.f) {
            fVar = (wm1.f) wordInfo;
        } else {
            fVar = null;
        }
        if (fVar != null) {
            Object b16 = fVar.b();
            if (b16 instanceof sk1.b) {
                bVar = (sk1.b) b16;
            }
        }
        if (bVar == null) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) translateInfo.c());
            fm1.i iVar = (fm1.i) first;
            int urlType = iVar.getUrlType();
            if (urlType != 1 && urlType != 3) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", 3);
                jSONObject.put("url_content", iVar.g());
                return jSONObject;
            }
            return h(iVar);
        }
        return i(bVar);
    }
}

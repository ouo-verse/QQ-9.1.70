package v8;

import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.b;
import com.qzone.proxy.feedcomponent.model.canvasAd.CanvasAdInfo;
import com.qzone.proxy.feedcomponent.model.canvasAd.CanvasButtonInfo;
import com.qzone.proxy.feedcomponent.model.canvasAd.CanvasComponent;
import com.qzone.proxy.feedcomponent.model.canvasAd.CanvasPage;
import com.qzone.proxy.feedcomponent.model.canvasAd.CanvasPanoramaInfo;
import com.qzone.proxy.feedcomponent.model.canvasAd.CanvasPicGroupComponent;
import com.qzone.proxy.feedcomponent.model.canvasAd.CanvasPicGroupItem;
import com.qzone.proxy.feedcomponent.model.canvasAd.CanvasPicInfo;
import com.qzone.proxy.feedcomponent.model.canvasAd.CanvasVideoInfo;
import com.qzone.publish.business.protocol.QZonePublishMoodRequest;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {
    public static List<CanvasComponent> b(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            CanvasComponent c16 = c(jSONArray.optJSONObject(i3));
            if (c16 != null) {
                arrayList.add(c16);
            }
        }
        return arrayList;
    }

    public static List<CanvasPage> k(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            CanvasPage j3 = j(jSONArray.optJSONObject(i3));
            if (j3 != null) {
                arrayList.add(j3);
            }
        }
        return arrayList;
    }

    public static CanvasAdInfo l(String str) {
        try {
            return a(new JSONObject(str).optJSONObject("adCanvasInfo"));
        } catch (JSONException unused) {
            return null;
        }
    }

    public static CanvasComponent e(JSONObject jSONObject) {
        if (jSONObject == null) {
            b.c("CanvasAdConvertHelper", "getComponentPanorama failed");
            return null;
        }
        CanvasPanoramaInfo canvasPanoramaInfo = new CanvasPanoramaInfo();
        canvasPanoramaInfo.componentId = jSONObject.optString("id");
        canvasPanoramaInfo.imageId = jSONObject.optString("imageId");
        try {
            canvasPanoramaInfo.componentType = jSONObject.getInt("type");
            canvasPanoramaInfo.imageWidth = jSONObject.getInt("imageWidth");
            canvasPanoramaInfo.imageHeight = jSONObject.getInt("imageHeight");
            String string = jSONObject.getString("imageUrl");
            canvasPanoramaInfo.imageUrl = string;
            if (canvasPanoramaInfo.imageWidth > 1080 && canvasPanoramaInfo.imageHeight > 0 && !TextUtils.isEmpty(string)) {
                return canvasPanoramaInfo;
            }
            b.c("CanvasAdConvertHelper", "getComponentPanorama failed");
            return null;
        } catch (JSONException e16) {
            b.c("CanvasAdConvertHelper", "getComponentPanorama failed");
            e16.printStackTrace();
            return null;
        }
    }

    public static CanvasAdInfo a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        CanvasAdInfo canvasAdInfo = new CanvasAdInfo();
        canvasAdInfo.canvasId = jSONObject.optString("id");
        canvasAdInfo.canvasName = jSONObject.optString("canvasName");
        canvasAdInfo.basicWidth = jSONObject.optInt("basicWidth");
        canvasAdInfo.basicRootFontSize = jSONObject.optInt("basicRootFontSize");
        canvasAdInfo.pageList = k(jSONObject.optJSONArray("PageList"));
        return canvasAdInfo;
    }

    public static CanvasComponent c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int optInt = jSONObject.optInt("type");
        if (optInt == 11) {
            return d(jSONObject);
        }
        if (optInt != 31) {
            switch (optInt) {
                case 21:
                    return f(jSONObject);
                case 22:
                    return g(jSONObject);
                case 23:
                    return e(jSONObject);
                default:
                    return null;
            }
        }
        return i(jSONObject);
    }

    public static CanvasComponent d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        CanvasButtonInfo canvasButtonInfo = new CanvasButtonInfo();
        canvasButtonInfo.componentId = jSONObject.optString("id");
        canvasButtonInfo.componentType = jSONObject.optInt("type");
        canvasButtonInfo.btnWidth = jSONObject.optInt("btnWidth");
        canvasButtonInfo.btnHeight = jSONObject.optInt("btnHeight");
        canvasButtonInfo.btnBgColor = jSONObject.optString("btnBgColor");
        canvasButtonInfo.btnTitle = jSONObject.optString("btnTitle");
        canvasButtonInfo.fontColor = jSONObject.optString("fontColor");
        canvasButtonInfo.fontSize = jSONObject.optInt("fontSize");
        canvasButtonInfo.borderWidth = jSONObject.optInt(NodeProps.BORDER_WIDTH);
        canvasButtonInfo.borderColor = jSONObject.optString(NodeProps.BORDER_COLOR);
        canvasButtonInfo.borderType = jSONObject.optInt("borderType");
        canvasButtonInfo.btnLinkUrl = jSONObject.optString("btnLinkUrl");
        canvasButtonInfo.paddingTop = jSONObject.optInt(NodeProps.PADDING_TOP);
        canvasButtonInfo.paddingBottom = jSONObject.optInt(NodeProps.PADDING_BOTTOM);
        return canvasButtonInfo;
    }

    public static CanvasComponent f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        CanvasPicInfo canvasPicInfo = new CanvasPicInfo();
        canvasPicInfo.componentId = jSONObject.optString("id");
        canvasPicInfo.componentType = jSONObject.optInt("type");
        canvasPicInfo.imageId = jSONObject.optString("imageId");
        canvasPicInfo.imageWidth = jSONObject.optInt("imageWidth");
        canvasPicInfo.imageHeight = jSONObject.optInt("imageHeight");
        canvasPicInfo.imageUrl = jSONObject.optString("imageUrl");
        canvasPicInfo.imageLink = jSONObject.optString("imageLink");
        canvasPicInfo.paddingTop = jSONObject.optInt(NodeProps.PADDING_TOP);
        canvasPicInfo.paddingBottom = jSONObject.optInt(NodeProps.PADDING_BOTTOM);
        return canvasPicInfo;
    }

    public static CanvasComponent g(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        CanvasPicGroupComponent canvasPicGroupComponent = new CanvasPicGroupComponent();
        canvasPicGroupComponent.componentId = jSONObject.optString("id");
        canvasPicGroupComponent.componentType = jSONObject.optInt("type");
        canvasPicGroupComponent.paddingTop = jSONObject.optInt(NodeProps.PADDING_TOP);
        canvasPicGroupComponent.paddingBottom = jSONObject.optInt(NodeProps.PADDING_BOTTOM);
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("imageGroupList");
        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
            CanvasPicGroupItem h16 = h(optJSONArray.optJSONObject(i3).optJSONObject("imageItem"));
            if (h16 != null) {
                arrayList.add(h16);
            }
        }
        canvasPicGroupComponent.imageGroupList = arrayList;
        return canvasPicGroupComponent;
    }

    public static CanvasPicGroupItem h(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        CanvasPicGroupItem canvasPicGroupItem = new CanvasPicGroupItem();
        canvasPicGroupItem.imageId = jSONObject.optString("imageId");
        canvasPicGroupItem.imageWidth = jSONObject.optInt("imageWidth");
        canvasPicGroupItem.imageHeight = jSONObject.optInt("imageHeight");
        canvasPicGroupItem.imageUrl = jSONObject.optString("imageUrl");
        canvasPicGroupItem.imageLink = jSONObject.optString("imageLink");
        return canvasPicGroupItem;
    }

    public static CanvasComponent i(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        CanvasVideoInfo canvasVideoInfo = new CanvasVideoInfo();
        canvasVideoInfo.componentId = jSONObject.optString("id");
        canvasVideoInfo.componentType = jSONObject.optInt("type");
        canvasVideoInfo.loopType = jSONObject.optInt("loopType");
        canvasVideoInfo.videoId = jSONObject.optString("videoId");
        canvasVideoInfo.videoWidth = jSONObject.optInt("videoWidth");
        canvasVideoInfo.videoHeight = jSONObject.optInt("videoHeight");
        canvasVideoInfo.videoDuration = jSONObject.optInt("videoDuration");
        canvasVideoInfo.videoSize = jSONObject.optInt(QZonePublishMoodRequest.EXT_INFO_KEY_VIDEO_SIZE);
        canvasVideoInfo.videoUrl = jSONObject.optString(AppConstants.Key.KEY_QZONE_VIDEO_URL);
        canvasVideoInfo.thumbUrl = jSONObject.optString("thumbUrl");
        canvasVideoInfo.paddingTop = jSONObject.optInt(NodeProps.PADDING_TOP);
        canvasVideoInfo.paddingBottom = jSONObject.optInt(NodeProps.PADDING_BOTTOM);
        return canvasVideoInfo;
    }

    public static CanvasPage j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        CanvasPage canvasPage = new CanvasPage();
        canvasPage.pageId = jSONObject.optString("id");
        canvasPage.backgroundColor = jSONObject.optString("backgroundColor");
        canvasPage.componentItemList = b(jSONObject.optJSONArray("componentItemList"));
        return canvasPage;
    }
}

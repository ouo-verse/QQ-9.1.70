package uj;

import android.view.View;
import com.qzone.reborn.base.l;
import com.qzone.reborn.intimate.layer.bean.QZIntimateLayerExtraInfoBean;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pk.c;
import qzone.QZoneBaseCommon$StCommonExt;
import tl.h;
import vj.e;
import wj.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00018B\u0007\u00a2\u0006\u0004\b6\u00107J\u001a\u0010\u0006\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0014J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0014J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J(\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0014H\u0014J\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003R$\u0010\u001f\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010&\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010.\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u00105\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104\u00a8\u00069"}, d2 = {"Luj/a;", "Lcom/qzone/reborn/base/l;", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "", "", "", "v", "w", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "", NodeProps.VISIBLE, "onVisibleChanged", "data", "", "position", "", "payload", "onBindData", "u", "Lqzone/QZoneBaseCommon$StCommonExt;", "e", "Lqzone/QZoneBaseCommon$StCommonExt;", "getCommonExt", "()Lqzone/QZoneBaseCommon$StCommonExt;", "setCommonExt", "(Lqzone/QZoneBaseCommon$StCommonExt;)V", "commonExt", "f", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "getMediaInfo", "()Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "setMediaInfo", "(Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;)V", "mediaInfo", "Lcom/qzone/reborn/intimate/layer/bean/QZIntimateLayerExtraInfoBean;", h.F, "Lcom/qzone/reborn/intimate/layer/bean/QZIntimateLayerExtraInfoBean;", "getExtraInfo", "()Lcom/qzone/reborn/intimate/layer/bean/QZIntimateLayerExtraInfoBean;", "setExtraInfo", "(Lcom/qzone/reborn/intimate/layer/bean/QZIntimateLayerExtraInfoBean;)V", "extraInfo", "i", "Ljava/lang/String;", "getFeedId", "()Ljava/lang/String;", "setFeedId", "(Ljava/lang/String;)V", "feedId", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a extends l<RFWLayerItemMediaInfo> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QZoneBaseCommon$StCommonExt commonExt;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RFWLayerItemMediaInfo mediaInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QZIntimateLayerExtraInfoBean extraInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String feedId = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\"\u0010\f\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Luj/a$a;", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "", "event", "", "", "getDynamicParams", "Ljava/lang/ref/WeakReference;", "Luj/a;", "kotlin.jvm.PlatformType", "a", "Ljava/lang/ref/WeakReference;", "weakReference", "section", "<init>", "(Luj/a;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: uj.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    private static final class C11353a implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<a> weakReference;

        public C11353a(a section) {
            Intrinsics.checkNotNullParameter(section, "section");
            this.weakReference = new WeakReference<>(section);
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String event) {
            Map<String, Object> u16;
            a aVar = this.weakReference.get();
            return (aVar == null || (u16 = aVar.u()) == null) ? new LinkedHashMap() : u16;
        }
    }

    private final Map<String, Object> v() {
        return null;
    }

    private final String w() {
        return "pg_qz_superposed_layer";
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public /* bridge */ /* synthetic */ void onBindData(Object obj, int i3, List list) {
        onBindData((RFWLayerItemMediaInfo) obj, i3, (List<Object>) list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        VideoReport.setPageId(containerView, w());
        VideoReport.setPageParams(containerView, new fo.a().d("QZoneBaseLayerFragment", v()));
        VideoReport.setEventDynamicParams(containerView, new C11353a(this));
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onVisibleChanged(boolean visible) {
        super.onVisibleChanged(visible);
        HashMap hashMap = new HashMap();
        c cVar = (c) RFWIocAbilityProvider.g().getIocInterface(c.class, this.mRootView, null);
        int T7 = cVar != null ? cVar.T7() : 1;
        c cVar2 = (c) RFWIocAbilityProvider.g().getIocInterface(c.class, this.mRootView, null);
        int currentPosition = cVar2 != null ? cVar2.getCurrentPosition() : 1;
        hashMap.put("pic_cnt", Integer.valueOf(T7));
        hashMap.put("is_last_page", Integer.valueOf(currentPosition != T7 ? 0 : 1));
        if (visible) {
            VideoReport.reportPgIn(this.mRootView);
            e eVar = e.f441735a;
            View mRootView = this.mRootView;
            Intrinsics.checkNotNullExpressionValue(mRootView, "mRootView");
            eVar.c(hashMap, "em_qz_page_turning_floating", mRootView);
            return;
        }
        VideoReport.reportPgOut(this.mRootView);
        e eVar2 = e.f441735a;
        View mRootView2 = this.mRootView;
        Intrinsics.checkNotNullExpressionValue(mRootView2, "mRootView");
        eVar2.d(hashMap, "em_qz_page_turning_floating", mRootView2);
    }

    public final Map<String, Object> u() {
        String str;
        String str2;
        d E;
        d E2;
        String spaceId;
        RFWLayerPicInfo layerPicInfo;
        RFWLayerPicInfo.RFWPicInfo currentPicInfo;
        d E3;
        HashMap hashMap = new HashMap();
        qj.a aVar = (qj.a) RFWIocAbilityProvider.g().getIocInterface(qj.a.class, this.mRootView, null);
        String str3 = "";
        if (aVar == null || (E3 = aVar.E()) == null || (str = E3.getFeedId()) == null) {
            str = "";
        }
        hashMap.put("feedid", str);
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mediaInfo;
        if (rFWLayerItemMediaInfo == null || (layerPicInfo = rFWLayerItemMediaInfo.getLayerPicInfo()) == null || (currentPicInfo = layerPicInfo.getCurrentPicInfo()) == null || (str2 = currentPicInfo.getUrl()) == null) {
            str2 = "";
        }
        hashMap.put("pic_url", str2);
        mk.h hVar = mk.h.f416877a;
        QZIntimateLayerExtraInfoBean qZIntimateLayerExtraInfoBean = this.extraInfo;
        hashMap.put("framer_uin", Long.valueOf(hVar.f(qZIntimateLayerExtraInfoBean != null ? qZIntimateLayerExtraInfoBean.getUploadUid() : null, this.commonExt)));
        qj.a aVar2 = (qj.a) RFWIocAbilityProvider.g().getIocInterface(qj.a.class, this.mRootView, null);
        if (aVar2 != null && (E2 = aVar2.E()) != null && (spaceId = E2.getSpaceId()) != null) {
            str3 = spaceId;
        }
        hashMap.put("close_friend_space_id", str3);
        qj.a aVar3 = (qj.a) RFWIocAbilityProvider.g().getIocInterface(qj.a.class, this.mRootView, null);
        hashMap.put("close_friend_space_type", Integer.valueOf((aVar3 == null || (E = aVar3.E()) == null) ? 0 : E.getSpaceType()));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    protected void onBindData(RFWLayerItemMediaInfo data, int position, List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.getExtraData() instanceof QZIntimateLayerExtraInfoBean) {
            Object extraData = data.getExtraData();
            Intrinsics.checkNotNull(extraData, "null cannot be cast to non-null type com.qzone.reborn.intimate.layer.bean.QZIntimateLayerExtraInfoBean");
            this.extraInfo = (QZIntimateLayerExtraInfoBean) extraData;
            this.mediaInfo = data;
        }
    }
}

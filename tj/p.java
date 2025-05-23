package tj;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.intimate.layer.bean.QZIntimateLayerExtraInfoBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZoneBaseMeta$StMedia;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0006\u0010#\u001a\u00020\u001f\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0014R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006&"}, d2 = {"Ltj/p;", "Ltj/f;", "Lcom/qzone/reborn/intimate/layer/bean/QZIntimateLayerExtraInfoBean;", "", "N9", "J9", "H9", "Lsj/e;", "I9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "onLayerStateUpdate", "Lvj/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lvj/c;", "getDataRepo", "()Lvj/c;", "dataRepo", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "deleteRoot", "Landroid/widget/ImageView;", "D", "Landroid/widget/ImageView;", "deleteIcon", "", "E", "I", WadlProxyConsts.SCENE_ID, "deleteSceneId", "<init>", "(ILvj/c;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class p extends f<QZIntimateLayerExtraInfoBean> {

    /* renamed from: C, reason: from kotlin metadata */
    private View deleteRoot;

    /* renamed from: D, reason: from kotlin metadata */
    private ImageView deleteIcon;

    /* renamed from: E, reason: from kotlin metadata */
    private int sceneId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final vj.c dataRepo;

    public p(int i3, vj.c cVar) {
        this.dataRepo = cVar;
        this.sceneId = i3;
    }

    private final void H9() {
        ((wj.f) getViewModel(wj.f.class)).O1(I9());
    }

    private final sj.e I9() {
        sj.e eVar = new sj.e();
        eVar.h(this.sceneId);
        eVar.l(getSpaceId());
        QZIntimateLayerExtraInfoBean x95 = x9();
        eVar.e(x95 != null ? x95.getAlbumId() : null);
        ArrayList arrayList = new ArrayList();
        if (this.mCurrentSelectedItem != null && x9() != null) {
            vj.d dVar = vj.d.f441734a;
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
            Intrinsics.checkNotNull(rFWLayerItemMediaInfo);
            QZIntimateLayerExtraInfoBean x96 = x9();
            Intrinsics.checkNotNull(x96);
            arrayList.add(dVar.a(rFWLayerItemMediaInfo, x96));
            ArrayList<CommonStMedia> c16 = eVar.c();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                c16.add(mj.b.b((QZoneBaseMeta$StMedia) it.next()));
            }
            eVar.k(this.dataRepo);
        }
        return eVar;
    }

    private final void J9() {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getContext(), 230, HardCodeUtil.qqStr(R.string.ssh), HardCodeUtil.qqStr(R.string.srn), HardCodeUtil.qqStr(R.string.sqw), HardCodeUtil.qqStr(R.string.srk), new DialogInterface.OnClickListener() { // from class: tj.n
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                p.K9(p.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: tj.o
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                p.L9(dialogInterface, i3);
            }
        });
        Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(\n    \u2026nt -> dialog1.dismiss() }");
        createCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(p this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.H9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(DialogInterface dialog1, int i3) {
        Intrinsics.checkNotNullParameter(dialog1, "dialog1");
        dialog1.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(p this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.J9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void N9() {
        String str;
        bk.e eVar = bk.e.f28497a;
        QZIntimateLayerExtraInfoBean x95 = x9();
        if (x95 == null || (str = x95.getUploadUid()) == null) {
            str = "";
        }
        if (eVar.f(str)) {
            View view = this.deleteRoot;
            if (view == null) {
                return;
            }
            view.setVisibility(0);
            return;
        }
        View view2 = this.deleteRoot;
        if (view2 == null) {
            return;
        }
        view2.setVisibility(8);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        View findViewById = rootView != null ? rootView.findViewById(R.id.n4f) : null;
        View findViewById2 = findViewById != null ? findViewById.findViewById(R.id.n4t) : null;
        View inflate = LayoutInflater.from(rootView != null ? rootView.getContext() : null).inflate(R.layout.cll, (ViewGroup) null);
        this.deleteRoot = inflate;
        if (findViewById2 == null || inflate == null) {
            return;
        }
        Intrinsics.checkNotNull(inflate);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.n6j);
        this.deleteIcon = imageView;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.f14452c);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ImmersiveUtils.dpToPx(32.0f), ImmersiveUtils.dpToPx(32.0f));
        View view = this.deleteRoot;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: tj.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    p.M9(p.this, view2);
                }
            });
        }
        layoutParams.setMarginEnd(ImmersiveUtils.dpToPx(10.0f));
        fo.c.n(this.deleteRoot, "em_qz_view_delete");
        ((ViewGroup) findViewById2).addView(this.deleteRoot, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.i
    public void onLayerStateUpdate(RFWLayerState layerState) {
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        N9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
    }
}

package xb;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.qzone.reborn.albumx.common.bean.CommonAlbumListBean;
import com.qzone.reborn.albumx.common.convert.bean.CommonMemoryVideo;
import com.qzone.util.ar;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0003J\b\u0010\u000b\u001a\u00020\nH\u0014J\b\u0010\r\u001a\u00020\fH\u0014J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J*\u0010\u0016\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0014J\u0012\u0010\u0018\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u000eH\u0016R\u0014\u0010\u001b\u001a\u00020\n8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010\"R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006,"}, d2 = {"Lxb/r;", "Lcom/qzone/reborn/base/l;", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumListBean;", "Landroid/view/View$OnClickListener;", "", "B", "data", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "w", HippyTKDListViewAdapter.X, "", "getLogTag", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "", "position", "", "", "payload", BdhLogUtil.LogTag.Tag_Conn, "v", NodeProps.ON_CLICK, "e", "Ljava/lang/String;", "TAG", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", "f", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", "mItemView", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "mAlbumPicView", "i", "mAlbumPicErrorView", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "mAlbumNameText", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class r extends com.qzone.reborn.base.l<CommonAlbumListBean> implements View.OnClickListener {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "QZAlbumxAlbumListTimeMachineSinglePicSection";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RoundCorneredFrameLayout mItemView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView mAlbumPicView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView mAlbumPicErrorView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView mAlbumNameText;

    private final void B() {
        RoundCorneredFrameLayout roundCorneredFrameLayout = this.mItemView;
        ImageView imageView = null;
        if (roundCorneredFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mItemView");
            roundCorneredFrameLayout = null;
        }
        ViewGroup.LayoutParams layoutParams = roundCorneredFrameLayout.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = (pl.a.f426446a.o(p()) - ar.e(48.0f)) / 2;
        }
        RoundCorneredFrameLayout roundCorneredFrameLayout2 = this.mItemView;
        if (roundCorneredFrameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mItemView");
            roundCorneredFrameLayout2 = null;
        }
        ViewGroup.LayoutParams layoutParams2 = roundCorneredFrameLayout2.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.width = (pl.a.f426446a.o(p()) - ar.e(48.0f)) / 2;
        }
        ImageView imageView2 = this.mAlbumPicErrorView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumPicErrorView");
        } else {
            imageView = imageView2;
        }
        rn.h.a(imageView, "qui_image", R.color.qui_common_icon_tertiary);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void w() {
        TextView textView = this.mAlbumNameText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumNameText");
            textView = null;
        }
        textView.setText(((CommonAlbumListBean) this.mData).getAlbumInfo().getMemoryInfo().b().get(0).getTitle());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void x() {
        String coverUrl = ((CommonAlbumListBean) this.mData).getAlbumInfo().getMemoryInfo().b().get(0).getCoverUrl();
        ImageView imageView = this.mAlbumPicView;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumPicView");
            imageView = null;
        }
        if (imageView.getTag() != null) {
            ImageView imageView3 = this.mAlbumPicView;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumPicView");
                imageView3 = null;
            }
            if (Intrinsics.areEqual(imageView3.getTag(), coverUrl)) {
                return;
            }
        }
        ImageView imageView4 = this.mAlbumPicView;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumPicView");
            imageView4 = null;
        }
        imageView4.setTag(coverUrl);
        Option e16 = com.tencent.mobileqq.qzone.picload.c.e(coverUrl);
        ImageView imageView5 = this.mAlbumPicView;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumPicView");
            imageView5 = null;
        }
        e16.setTargetView(imageView5);
        ImageView imageView6 = this.mAlbumPicView;
        if (imageView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumPicView");
            imageView6 = null;
        }
        if (imageView6.getLayoutParams() != null) {
            ImageView imageView7 = this.mAlbumPicView;
            if (imageView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumPicView");
                imageView7 = null;
            }
            e16.setRequestWidth(imageView7.getLayoutParams().width);
            ImageView imageView8 = this.mAlbumPicView;
            if (imageView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumPicView");
                imageView8 = null;
            }
            e16.setRequestHeight(imageView8.getLayoutParams().height);
        }
        com.qzone.reborn.util.m mVar = com.qzone.reborn.util.m.f59551a;
        ImageView imageView9 = this.mAlbumPicView;
        if (imageView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumPicView");
            imageView9 = null;
        }
        e16.setLoadingDrawable(mVar.b(imageView9.getContext()));
        ImageView imageView10 = this.mAlbumPicView;
        if (imageView10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumPicView");
            imageView10 = null;
        }
        e16.setFailedDrawable(mVar.a(imageView10.getContext()));
        ImageView imageView11 = this.mAlbumPicErrorView;
        if (imageView11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumPicErrorView");
        } else {
            imageView2 = imageView11;
        }
        imageView2.setVisibility(8);
        com.tencent.mobileqq.qzone.picload.c.a().i(e16, new IPicLoadStateListener() { // from class: xb.p
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                r.y(r.this, loadState, option);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(final r this$0, LoadState loadState, Option option) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!loadState.isFinishError() || option == null) {
            return;
        }
        RFWLog.e(this$0.TAG, RFWLog.USR, "loadImage | state = " + loadState + " | url = " + option.getUrl());
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: xb.q
            @Override // java.lang.Runnable
            public final void run() {
                r.z(r.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(r this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView imageView = this$0.mAlbumPicErrorView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumPicErrorView");
            imageView = null;
        }
        imageView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: getLogTag, reason: from getter */
    public String getTAG() {
        return this.TAG;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(v3);
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.n3j && ((CommonAlbumListBean) this.mData).getAlbumInfo().getMemoryInfo().b().size() > 0) {
            if (((CommonAlbumListBean) this.mData).getAlbumInfo().getMemoryInfo().b().size() > 1) {
                str = ((CommonAlbumListBean) this.mData).getAlbumInfo().getMemoryInfo().getAggregationPageUrl();
            } else {
                str = ((CommonAlbumListBean) this.mData).getAlbumInfo().getMemoryInfo().b().get(0).getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_JUMP_URL java.lang.String();
            }
            QLog.i(this.TAG, 1, "onClick  url = " + str);
            ho.i.q(getRootView().getContext(), str);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.n3j);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026e_intimate_album_content)");
        this.mItemView = (RoundCorneredFrameLayout) findViewById;
        View findViewById2 = containerView.findViewById(R.id.n3u);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026intimate_album_pic_error)");
        this.mAlbumPicErrorView = (ImageView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.n3t);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026qzone_intimate_album_pic)");
        this.mAlbumPicView = (ImageView) findViewById3;
        View findViewById4 = containerView.findViewById(R.id.nhq);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewBy\u2026(R.id.tv_albumx_pic_name)");
        this.mAlbumNameText = (TextView) findViewById4;
        RoundCorneredFrameLayout roundCorneredFrameLayout = this.mItemView;
        RoundCorneredFrameLayout roundCorneredFrameLayout2 = null;
        if (roundCorneredFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mItemView");
            roundCorneredFrameLayout = null;
        }
        roundCorneredFrameLayout.setRadius(ar.d(8.0f));
        B();
        RoundCorneredFrameLayout roundCorneredFrameLayout3 = this.mItemView;
        if (roundCorneredFrameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mItemView");
        } else {
            roundCorneredFrameLayout2 = roundCorneredFrameLayout3;
        }
        roundCorneredFrameLayout2.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.nlc};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public void onBindData(CommonAlbumListBean data, int position, List<Object> payload) {
        if (data != null) {
            RoundCorneredFrameLayout roundCorneredFrameLayout = null;
            if (data.getAlbumInfo().getMemoryInfo().b().size() > 0 && data.getAlbumInfo().getMemoryInfo().b().size() < 4) {
                RoundCorneredFrameLayout roundCorneredFrameLayout2 = this.mItemView;
                if (roundCorneredFrameLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mItemView");
                } else {
                    roundCorneredFrameLayout = roundCorneredFrameLayout2;
                }
                roundCorneredFrameLayout.setVisibility(0);
                x();
                w();
                A(data);
                return;
            }
            RoundCorneredFrameLayout roundCorneredFrameLayout3 = this.mItemView;
            if (roundCorneredFrameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mItemView");
            } else {
                roundCorneredFrameLayout = roundCorneredFrameLayout3;
            }
            roundCorneredFrameLayout.setVisibility(8);
        }
    }

    private final void A(CommonAlbumListBean data) {
        if (data == null) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("topics_number", Integer.valueOf(data.getAlbumInfo().getMemoryInfo().b().size()));
        String str = "";
        for (CommonMemoryVideo commonMemoryVideo : data.getAlbumInfo().getMemoryInfo().b()) {
            if (!TextUtils.isEmpty(str)) {
                str = str + ";";
            }
            str = str + commonMemoryVideo.getTemplateId();
        }
        linkedHashMap.put(ShortVideoConstants.VIDEO_TOPIC_ID, str);
        fo.b i3 = new fo.b().l(linkedHashMap).i(data.getAlbumInfo().getAlbumId());
        RoundCorneredFrameLayout roundCorneredFrameLayout = this.mItemView;
        if (roundCorneredFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mItemView");
            roundCorneredFrameLayout = null;
        }
        fo.c.o(roundCorneredFrameLayout, "em_qz_ai_timemachine_entry", i3);
    }
}

package xb;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.common.bean.CommonAlbumListBean;
import com.qzone.reborn.albumx.common.convert.bean.CommonMemoryVideo;
import com.qzone.util.ar;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
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
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001e\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007\u00a2\u0006\u0004\bA\u0010BJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nH\u0003J\b\u0010\u0011\u001a\u00020\u0010H\u0014J\b\u0010\u0013\u001a\u00020\u0012H\u0014J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0014J*\u0010\u001c\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0018\u001a\u00020\u00172\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019H\u0014J\u0012\u0010\u001d\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0014H\u0016R\u0014\u0010 \u001a\u00020\u00108\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u0010'R\u0016\u00102\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u0010*R\u0016\u00104\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u0010-R\u0016\u00106\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u0010'R\u0016\u00108\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u0010*R\u0016\u0010:\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010-R\u0016\u0010<\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010'R\u0016\u0010>\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010*R\u0016\u0010@\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010-\u00a8\u0006C"}, d2 = {"Lxb/m;", "Lcom/qzone/reborn/base/l;", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumListBean;", "Landroid/view/View$OnClickListener;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "data", "y", "Landroid/widget/TextView;", "nameTextView", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonMemoryVideo;", "memoryVideo", "v", "Landroid/widget/ImageView;", "picView", "w", "", "getLogTag", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "", "position", "", "", "payload", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, NodeProps.ON_CLICK, "e", "Ljava/lang/String;", "TAG", "Landroid/widget/LinearLayout;", "f", "Landroid/widget/LinearLayout;", "mItemView", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", tl.h.F, "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", "mRoundLayout1", "i", "Landroid/widget/ImageView;", "mAlbumPic1", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "mAlbumName1", BdhLogUtil.LogTag.Tag_Conn, "mRoundLayout2", "D", "mAlbumPic2", "E", "mAlbumName2", UserInfo.SEX_FEMALE, "mRoundLayout3", "G", "mAlbumPic3", "H", "mAlbumName3", "I", "mRoundLayout4", "J", "mAlbumPic4", "K", "mAlbumName4", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class m extends com.qzone.reborn.base.l<CommonAlbumListBean> implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private RoundCorneredFrameLayout mRoundLayout2;

    /* renamed from: D, reason: from kotlin metadata */
    private ImageView mAlbumPic2;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView mAlbumName2;

    /* renamed from: F, reason: from kotlin metadata */
    private RoundCorneredFrameLayout mRoundLayout3;

    /* renamed from: G, reason: from kotlin metadata */
    private ImageView mAlbumPic3;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView mAlbumName3;

    /* renamed from: I, reason: from kotlin metadata */
    private RoundCorneredFrameLayout mRoundLayout4;

    /* renamed from: J, reason: from kotlin metadata */
    private ImageView mAlbumPic4;

    /* renamed from: K, reason: from kotlin metadata */
    private TextView mAlbumName4;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "QZAlbumxAlbumListTimeMachineFourPicSection";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mItemView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RoundCorneredFrameLayout mRoundLayout1;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView mAlbumPic1;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView mAlbumName1;

    private final void v(TextView nameTextView, CommonMemoryVideo memoryVideo) {
        nameTextView.setText(memoryVideo.getTitle());
    }

    private final void w(ImageView picView, CommonMemoryVideo memoryVideo) {
        String coverUrl = memoryVideo.getCoverUrl();
        if (picView.getTag() == null || !Intrinsics.areEqual(picView.getTag(), coverUrl)) {
            picView.setTag(coverUrl);
            Option e16 = com.tencent.mobileqq.qzone.picload.c.e(coverUrl);
            e16.setTargetView(picView);
            if (picView.getLayoutParams() != null) {
                e16.setRequestWidth(picView.getLayoutParams().width);
                e16.setRequestHeight(picView.getLayoutParams().height);
            }
            com.qzone.reborn.util.m mVar = com.qzone.reborn.util.m.f59551a;
            e16.setLoadingDrawable(mVar.b(picView.getContext()));
            e16.setFailedDrawable(mVar.a(picView.getContext()));
            com.tencent.mobileqq.qzone.picload.c.a().i(e16, new IPicLoadStateListener() { // from class: xb.l
                @Override // com.tencent.libra.listener.IPicLoadStateListener
                public final void onStateChange(LoadState loadState, Option option) {
                    m.x(m.this, loadState, option);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(m this$0, LoadState loadState, Option option) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!loadState.isFinishError() || option == null) {
            return;
        }
        RFWLog.e(this$0.TAG, RFWLog.USR, "loadImage | state = " + loadState + " | url = " + option.getUrl());
    }

    private final void z() {
        LinearLayout linearLayout = this.mItemView;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mItemView");
            linearLayout = null;
        }
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = (pl.a.f426446a.o(p()) - ar.e(48.0f)) / 2;
        }
        LinearLayout linearLayout3 = this.mItemView;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mItemView");
        } else {
            linearLayout2 = linearLayout3;
        }
        ViewGroup.LayoutParams layoutParams2 = linearLayout2.getLayoutParams();
        if (layoutParams2 == null) {
            return;
        }
        layoutParams2.width = (pl.a.f426446a.o(p()) - ar.e(48.0f)) / 2;
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
        EventCollector.getInstance().onViewClickedBefore(v3);
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.n6c) {
            String aggregationPageUrl = ((CommonAlbumListBean) this.mData).getAlbumInfo().getMemoryInfo().getAggregationPageUrl();
            QLog.i(this.TAG, 1, "onClick  url = " + aggregationPageUrl);
            ho.i.q(getRootView().getContext(), aggregationPageUrl);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.n6c);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026item_machine_card_layout)");
        this.mItemView = (LinearLayout) findViewById;
        View findViewById2 = containerView.findViewById(R.id.nex);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026.round_cornered_layout_1)");
        RoundCorneredFrameLayout roundCorneredFrameLayout = (RoundCorneredFrameLayout) findViewById2;
        this.mRoundLayout1 = roundCorneredFrameLayout;
        LinearLayout linearLayout = null;
        if (roundCorneredFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRoundLayout1");
            roundCorneredFrameLayout = null;
        }
        roundCorneredFrameLayout.setRadius(ar.d(8.0f));
        View findViewById3 = containerView.findViewById(R.id.lve);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026time_machine_album_pic_1)");
        this.mAlbumPic1 = (ImageView) findViewById3;
        View findViewById4 = containerView.findViewById(R.id.nhr);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewBy\u2026.id.tv_albumx_pic_name_1)");
        this.mAlbumName1 = (TextView) findViewById4;
        View findViewById5 = containerView.findViewById(R.id.ney);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "containerView.findViewBy\u2026.round_cornered_layout_2)");
        RoundCorneredFrameLayout roundCorneredFrameLayout2 = (RoundCorneredFrameLayout) findViewById5;
        this.mRoundLayout2 = roundCorneredFrameLayout2;
        if (roundCorneredFrameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRoundLayout2");
            roundCorneredFrameLayout2 = null;
        }
        roundCorneredFrameLayout2.setRadius(ar.d(8.0f));
        View findViewById6 = containerView.findViewById(R.id.lvf);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "containerView.findViewBy\u2026time_machine_album_pic_2)");
        this.mAlbumPic2 = (ImageView) findViewById6;
        View findViewById7 = containerView.findViewById(R.id.nhs);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "containerView.findViewBy\u2026.id.tv_albumx_pic_name_2)");
        this.mAlbumName2 = (TextView) findViewById7;
        View findViewById8 = containerView.findViewById(R.id.nez);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "containerView.findViewBy\u2026.round_cornered_layout_3)");
        RoundCorneredFrameLayout roundCorneredFrameLayout3 = (RoundCorneredFrameLayout) findViewById8;
        this.mRoundLayout3 = roundCorneredFrameLayout3;
        if (roundCorneredFrameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRoundLayout3");
            roundCorneredFrameLayout3 = null;
        }
        roundCorneredFrameLayout3.setRadius(ar.d(8.0f));
        View findViewById9 = containerView.findViewById(R.id.lvg);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "containerView.findViewBy\u2026time_machine_album_pic_3)");
        this.mAlbumPic3 = (ImageView) findViewById9;
        View findViewById10 = containerView.findViewById(R.id.nht);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "containerView.findViewBy\u2026.id.tv_albumx_pic_name_3)");
        this.mAlbumName3 = (TextView) findViewById10;
        View findViewById11 = containerView.findViewById(R.id.f162935nf0);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "containerView.findViewBy\u2026.round_cornered_layout_4)");
        RoundCorneredFrameLayout roundCorneredFrameLayout4 = (RoundCorneredFrameLayout) findViewById11;
        this.mRoundLayout4 = roundCorneredFrameLayout4;
        if (roundCorneredFrameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRoundLayout4");
            roundCorneredFrameLayout4 = null;
        }
        roundCorneredFrameLayout4.setRadius(ar.d(8.0f));
        View findViewById12 = containerView.findViewById(R.id.lvi);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "containerView.findViewBy\u2026time_machine_album_pic_4)");
        this.mAlbumPic4 = (ImageView) findViewById12;
        View findViewById13 = containerView.findViewById(R.id.nhu);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "containerView.findViewBy\u2026.id.tv_albumx_pic_name_4)");
        this.mAlbumName4 = (TextView) findViewById13;
        z();
        LinearLayout linearLayout2 = this.mItemView;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mItemView");
        } else {
            linearLayout = linearLayout2;
        }
        linearLayout.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.nlb};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.widget.LinearLayout] */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void onBindData(CommonAlbumListBean data, int position, List<Object> payload) {
        if (data != null) {
            TextView textView = null;
            if (data.getAlbumInfo().getMemoryInfo().b().size() < 4) {
                ?? r36 = this.mItemView;
                if (r36 == 0) {
                    Intrinsics.throwUninitializedPropertyAccessException("mItemView");
                } else {
                    textView = r36;
                }
                textView.setVisibility(8);
                return;
            }
            LinearLayout linearLayout = this.mItemView;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mItemView");
                linearLayout = null;
            }
            linearLayout.setVisibility(0);
            ImageView imageView = this.mAlbumPic1;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumPic1");
                imageView = null;
            }
            w(imageView, data.getAlbumInfo().getMemoryInfo().b().get(0));
            TextView textView2 = this.mAlbumName1;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumName1");
                textView2 = null;
            }
            v(textView2, data.getAlbumInfo().getMemoryInfo().b().get(0));
            ImageView imageView2 = this.mAlbumPic2;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumPic2");
                imageView2 = null;
            }
            w(imageView2, data.getAlbumInfo().getMemoryInfo().b().get(1));
            TextView textView3 = this.mAlbumName2;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumName2");
                textView3 = null;
            }
            v(textView3, data.getAlbumInfo().getMemoryInfo().b().get(1));
            ImageView imageView3 = this.mAlbumPic3;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumPic3");
                imageView3 = null;
            }
            w(imageView3, data.getAlbumInfo().getMemoryInfo().b().get(2));
            TextView textView4 = this.mAlbumName3;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumName3");
                textView4 = null;
            }
            v(textView4, data.getAlbumInfo().getMemoryInfo().b().get(2));
            ImageView imageView4 = this.mAlbumPic4;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumPic4");
                imageView4 = null;
            }
            w(imageView4, data.getAlbumInfo().getMemoryInfo().b().get(3));
            TextView textView5 = this.mAlbumName4;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumName4");
            } else {
                textView = textView5;
            }
            v(textView, data.getAlbumInfo().getMemoryInfo().b().get(3));
            y(data);
        }
    }

    private final void y(CommonAlbumListBean data) {
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
        LinearLayout linearLayout = this.mItemView;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mItemView");
            linearLayout = null;
        }
        fo.c.o(linearLayout, "em_qz_ai_timemachine_entry", i3);
    }
}

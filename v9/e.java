package v9;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.common.bean.CommonAlbumListBean;
import com.qzone.reborn.albumx.common.convert.bean.CommonStPicUrl;
import com.qzone.reborn.base.l;
import com.qzone.reborn.util.m;
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
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0003J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\tH\u0014J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0014J*\u0010\u0014\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0014J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016R\u0014\u0010\u0019\u001a\u00020\u00158\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00158\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\"\u0010#\u001a\u00020\u001c8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010,\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010&R\u0016\u0010-\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0005\u0010*\u00a8\u00060"}, d2 = {"Lv9/e;", "Lcom/qzone/reborn/base/l;", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumListBean;", "Landroid/view/View$OnClickListener;", "", "D", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, HippyTKDListViewAdapter.X, "w", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "", "position", "", "", "payload", UserInfo.SEX_FEMALE, "", BdhLogUtil.LogTag.Tag_Conn, "e", "Ljava/lang/String;", "TAG", "f", "DEFAULT_COVER_URL", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", h.F, "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", "B", "()Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", "G", "(Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;)V", "mItemView", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "mAlbumPicView", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "mAlbumToFlagView", "mAlbumPicErrorView", "mAlbumCountView", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public abstract class e extends l<CommonAlbumListBean> implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView mAlbumPicErrorView;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView mAlbumCountView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "QZoneMultiplexAlbumListNormalSection";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final String DEFAULT_COVER_URL = "https://qzonestyle.gtimg.cn/qzone/client/mqq/photo-album/photo-cover-empt.png";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    protected RoundCorneredFrameLayout mItemView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView mAlbumPicView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView mAlbumToFlagView;

    /* JADX WARN: Multi-variable type inference failed */
    private final void A() {
        TextView textView = null;
        if (((CommonAlbumListBean) this.mData).getAlbumInfo().getTopFlag() == 1) {
            TextView textView2 = this.mAlbumToFlagView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumToFlagView");
                textView2 = null;
            }
            textView2.setBackground(getRootView().getResources().getDrawable(R.drawable.f15694o));
            TextView textView3 = this.mAlbumToFlagView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumToFlagView");
                textView3 = null;
            }
            if ("#0099FF" instanceof Integer) {
                textView3.setTextColor(textView3.getResources().getColorStateList(((Number) "#0099FF").intValue()));
            } else {
                textView3.setTextColor(Color.parseColor("#0099FF"));
            }
            TextView textView4 = this.mAlbumToFlagView;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumToFlagView");
                textView4 = null;
            }
            textView4.setText(com.qzone.util.l.a(R.string.v7h));
            TextView textView5 = this.mAlbumToFlagView;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumToFlagView");
            } else {
                textView = textView5;
            }
            textView.setVisibility(0);
            return;
        }
        if (((CommonAlbumListBean) this.mData).getAlbumInfo().getOpInfo().getRecentlyUpdated()) {
            TextView textView6 = this.mAlbumToFlagView;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumToFlagView");
                textView6 = null;
            }
            textView6.setBackground(getRootView().getResources().getDrawable(R.drawable.f135809));
            TextView textView7 = this.mAlbumToFlagView;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumToFlagView");
                textView7 = null;
            }
            if ("#FFB300" instanceof Integer) {
                textView7.setTextColor(textView7.getResources().getColorStateList(((Number) "#FFB300").intValue()));
            } else {
                textView7.setTextColor(Color.parseColor("#FFB300"));
            }
            TextView textView8 = this.mAlbumToFlagView;
            if (textView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumToFlagView");
                textView8 = null;
            }
            textView8.setText(com.qzone.util.l.a(R.string.f134268c));
            TextView textView9 = this.mAlbumToFlagView;
            if (textView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumToFlagView");
            } else {
                textView = textView9;
            }
            textView.setVisibility(0);
            return;
        }
        TextView textView10 = this.mAlbumToFlagView;
        if (textView10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumToFlagView");
        } else {
            textView = textView10;
        }
        textView.setVisibility(8);
    }

    private final void D() {
        ViewGroup.LayoutParams layoutParams = B().getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = (pl.a.f426446a.o(p()) - ar.e(48.0f)) / 2;
        }
        ViewGroup.LayoutParams layoutParams2 = B().getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.width = (pl.a.f426446a.o(p()) - ar.e(48.0f)) / 2;
        }
        ImageView imageView = this.mAlbumPicErrorView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumPicErrorView");
            imageView = null;
        }
        rn.h.a(imageView, "qui_image", R.color.qui_common_icon_tertiary);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void w() {
        TextView textView = this.mAlbumCountView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumCountView");
            textView = null;
        }
        textView.setText(((CommonAlbumListBean) this.mData).getAlbumInfo().getUploadNumber() + C());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void x() {
        CommonStPicUrl f16 = k9.a.f(((CommonAlbumListBean) this.mData).getAlbumInfo());
        String str = this.DEFAULT_COVER_URL;
        if (!k9.a.i(f16)) {
            RFWLog.e(this.TAG, RFWLog.USR, "bindPicView getStPicUrl is null");
        } else {
            Intrinsics.checkNotNull(f16);
            str = f16.getUrl();
        }
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
            if (Intrinsics.areEqual(imageView3.getTag(), str)) {
                return;
            }
        }
        ImageView imageView4 = this.mAlbumPicView;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumPicView");
            imageView4 = null;
        }
        imageView4.setTag(str);
        Option e16 = com.tencent.mobileqq.qzone.picload.c.e(str);
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
        m mVar = m.f59551a;
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
        com.tencent.mobileqq.qzone.picload.c.a().i(e16, new IPicLoadStateListener() { // from class: v9.c
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                e.y(e.this, loadState, option);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(final e this$0, LoadState loadState, Option option) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!loadState.isFinishError() || option == null) {
            return;
        }
        RFWLog.e(this$0.TAG, RFWLog.USR, "loadImage | state = " + loadState + " | url = " + option.getUrl());
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: v9.d
            @Override // java.lang.Runnable
            public final void run() {
                e.z(e.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(e this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView imageView = this$0.mAlbumPicErrorView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumPicErrorView");
            imageView = null;
        }
        imageView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final RoundCorneredFrameLayout B() {
        RoundCorneredFrameLayout roundCorneredFrameLayout = this.mItemView;
        if (roundCorneredFrameLayout != null) {
            return roundCorneredFrameLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mItemView");
        return null;
    }

    protected final void G(RoundCorneredFrameLayout roundCorneredFrameLayout) {
        Intrinsics.checkNotNullParameter(roundCorneredFrameLayout, "<set-?>");
        this.mItemView = roundCorneredFrameLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.n3j);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026e_intimate_album_content)");
        G((RoundCorneredFrameLayout) findViewById);
        View findViewById2 = containerView.findViewById(R.id.n4a);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026_intimate_album_top_flag)");
        this.mAlbumToFlagView = (TextView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.n3u);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026intimate_album_pic_error)");
        this.mAlbumPicErrorView = (ImageView) findViewById3;
        View findViewById4 = containerView.findViewById(R.id.n3t);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewBy\u2026qzone_intimate_album_pic)");
        this.mAlbumPicView = (ImageView) findViewById4;
        B().setRadius(ar.d(8.0f));
        View findViewById5 = containerView.findViewById(R.id.n3k);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "containerView.findViewBy\u2026one_intimate_album_count)");
        this.mAlbumCountView = (TextView) findViewById5;
        D();
        B().setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.nlr};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: F */
    public void onBindData(CommonAlbumListBean data, int position, List<Object> payload) {
        if (data != null) {
            A();
            x();
            w();
        }
    }

    public String C() {
        return com.qzone.util.l.a(R.string.f133887b);
    }
}

package z50;

import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleAvatarLayerBean;
import com.tencent.biz.qqcircle.immersive.part.u;
import com.tencent.biz.qqcircle.picload.avatar.AvatarOption;
import com.tencent.biz.qqcircle.picload.avatar.QCircleAvatarLoader;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.multitouchimg.QCircleMultiTouchImageView;
import com.tencent.libra.LoadState;
import com.tencent.libra.download.LibraGroupKey;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta$StUser;

/* compiled from: P */
/* loaded from: classes4.dex */
public class e extends u {

    /* renamed from: d, reason: collision with root package name */
    private View f451955d;

    /* renamed from: e, reason: collision with root package name */
    private QCircleMultiTouchImageView f451956e;

    /* renamed from: f, reason: collision with root package name */
    private Size f451957f;

    /* renamed from: h, reason: collision with root package name */
    private QCircleAvatarLayerBean f451958h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends QCirclePicStateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f451959d;

        a(String str) {
            this.f451959d = str;
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            super.onStateChange(loadState, option);
            if (e.this.f451956e == null) {
                return;
            }
            if (loadState == LoadState.STATE_SUCCESS) {
                e.this.f451956e.setVisibility(0);
                return;
            }
            QLog.e(e.this.getTAG(), 1, "[onStateChange] error, state: " + loadState + ", userId: " + this.f451959d);
        }
    }

    public e(QCircleAvatarLayerBean qCircleAvatarLayerBean) {
        this.f451958h = qCircleAvatarLayerBean;
    }

    private void A9(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Option obtain = Option.obtain();
        LibraGroupKey libraGroupKey = new LibraGroupKey(str);
        libraGroupKey.setCacheStrategy(LibraGroupKey.CacheStrategy.HIGHEST);
        obtain.setGroupKey(libraGroupKey);
        obtain.setTargetView(this.f451956e);
        obtain.setUrl(str);
        obtain.setRequestWidth(this.f451957f.getWidth());
        obtain.setRequestHeight(this.f451957f.getHeight());
        QCircleFeedPicLoader.g().loadImage(obtain);
    }

    private void B9() {
        FeedCloudMeta$StUser user = this.f451958h.getUser();
        String str = user.icon.iconUrl.get();
        if (!TextUtils.isEmpty(str)) {
            A9(str);
        } else if (!TextUtils.isEmpty(user.f398463id.get())) {
            z9(user.f398463id.get());
        } else {
            QLog.e(getTAG(), 1, "[setUserInfo] iconUrl and userId is empty");
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSAvatarLayerPicPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        int g16 = cx.g();
        this.f451957f = new Size(g16, g16);
        this.f451955d = view.findViewById(R.id.f34000xz);
        this.f451956e = (QCircleMultiTouchImageView) view.findViewById(R.id.f33920xr);
        ViewGroup.LayoutParams layoutParams = this.f451955d.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = g16;
            layoutParams.height = g16;
            this.f451955d.setLayoutParams(layoutParams);
        }
        B9();
    }

    public void z9(String str) {
        FeedCloudMeta$StUser feedCloudMeta$StUser = new FeedCloudMeta$StUser();
        feedCloudMeta$StUser.f398463id.set(str);
        if (!QCirclePluginUtil.isOwner(feedCloudMeta$StUser) && uq3.c.p7()) {
            AvatarOption uin = new AvatarOption().setUin(str);
            uin.setTargetView(this.f451956e).setFromPreLoad(false);
            uin.setRequestWidth(this.f451957f.getWidth());
            uin.setRequestHeight(this.f451957f.getHeight());
            this.f451956e.setVisibility(8);
            QCircleAvatarLoader.g().loadAvatar(uin, new a(str));
            return;
        }
        this.f451956e.setImageDrawable(QCirclePluginGlobalInfo.p(str));
    }
}

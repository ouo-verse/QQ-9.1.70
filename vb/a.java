package vb;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import bb.h;
import com.qzone.reborn.albumx.qzonex.fragment.layer.QZAlbumxBatchLayerFragment;
import com.qzone.reborn.albumx.qzonex.fragment.layer.QZAlbumxDetailLayerFragment;
import com.qzone.reborn.albumx.qzonex.fragment.layer.QZAlbumxTabPicLayerFragment;
import com.qzone.reborn.feedx.util.m;
import com.qzone.reborn.layer.part.QZoneFeedXGalleryActivity;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.gallery.RFWLaunchKey;
import com.tencent.richframework.gallery.RFWLayerLaunchUtil;
import cooperation.qzone.util.PerfTracer;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\f"}, d2 = {"Lvb/a;", "Lho/a;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lbb/h;", "layerLaunchBean", "", "c", "b", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a implements ho.a {
    public final void a(Activity activity, h layerLaunchBean) {
        if (layerLaunchBean != null && activity != null) {
            Bundle bundle = new Bundle();
            bundle.putLong(PerfTracer.PARAM_CLICK_TIME, System.currentTimeMillis());
            bundle.putSerializable("key_init_data_list", layerLaunchBean.F());
            bundle.putBoolean(RFWLaunchKey.KEY_IS_CARVED_ANIM_OPEN, true);
            bundle.putString("key_feed_id", layerLaunchBean.getFeedId());
            bundle.putString("key_qzone_id", layerLaunchBean.getUin());
            bundle.putString("key_link_id", layerLaunchBean.getLinkId());
            m.b("extra_key_parcelable_selected_list_for_jump_batch_layer", layerLaunchBean.b0());
            if (layerLaunchBean.getAlbumDetailInitBean() != null) {
                bundle.putSerializable("key_album_detail_init_bean", layerLaunchBean.getAlbumDetailInitBean());
            }
            ImageView clickView = layerLaunchBean.getClickView();
            if (clickView != null) {
                clickView.setTag(RFWLaunchKey.ID_VIDEO_MUTE, Boolean.FALSE);
            }
            RFWLayerLaunchUtil.jumpToGallery(activity, layerLaunchBean.getClickView(), layerLaunchBean.g(), layerLaunchBean.getCurPos(), QZoneFeedXGalleryActivity.class, QZAlbumxBatchLayerFragment.class, bundle, 1010);
            return;
        }
        RFWLog.d("QZAlbumxGalleryNativeLauncher", RFWLog.USR, "launchAlbumBatchGallery fail, layerLaunchBean: " + layerLaunchBean + ", activity: " + activity);
    }

    public final void b(Activity activity, h layerLaunchBean) {
        if (layerLaunchBean != null && activity != null) {
            Bundle bundle = new Bundle();
            bundle.putLong(PerfTracer.PARAM_CLICK_TIME, System.currentTimeMillis());
            bundle.putSerializable("key_init_data_list", layerLaunchBean.F());
            bundle.putBoolean(RFWLaunchKey.KEY_IS_CARVED_ANIM_OPEN, true);
            bundle.putString("key_feed_id", layerLaunchBean.getFeedId());
            bundle.putString("key_qzone_id", layerLaunchBean.getUin());
            bundle.putString("key_link_id", layerLaunchBean.getLinkId());
            if (layerLaunchBean.getAlbumDetailInitBean() != null) {
                bundle.putSerializable("key_album_detail_init_bean", layerLaunchBean.getAlbumDetailInitBean());
            }
            ImageView clickView = layerLaunchBean.getClickView();
            if (clickView != null) {
                clickView.setTag(RFWLaunchKey.ID_VIDEO_MUTE, Boolean.FALSE);
            }
            RFWLayerLaunchUtil.jumpToGallery$default(activity, layerLaunchBean.getClickView(), layerLaunchBean.g(), layerLaunchBean.getCurPos(), QZoneFeedXGalleryActivity.class, QZAlbumxDetailLayerFragment.class, bundle, 0, 128, null);
            return;
        }
        RFWLog.d("QZAlbumxGalleryNativeLauncher", RFWLog.USR, "launchAlbumDetailGallery fail, layerLaunchBean: " + layerLaunchBean + ", activity: " + activity);
    }

    public final void c(Activity activity, h layerLaunchBean) {
        if (layerLaunchBean != null && activity != null) {
            Bundle bundle = new Bundle();
            bundle.putLong(PerfTracer.PARAM_CLICK_TIME, System.currentTimeMillis());
            bundle.putSerializable("key_init_data_list", layerLaunchBean.F());
            bundle.putBoolean(RFWLaunchKey.KEY_IS_CARVED_ANIM_OPEN, true);
            bundle.putString("key_qzone_id", layerLaunchBean.getUin());
            bundle.putString("key_data_repo_key", layerLaunchBean.getDataRepoKey());
            bundle.putString("key_link_id", layerLaunchBean.getLinkId());
            ImageView clickView = layerLaunchBean.getClickView();
            if (clickView != null) {
                clickView.setTag(RFWLaunchKey.ID_VIDEO_MUTE, Boolean.FALSE);
            }
            RFWLayerLaunchUtil.jumpToGallery$default(activity, layerLaunchBean.getClickView(), layerLaunchBean.g(), layerLaunchBean.getCurPos(), QZoneFeedXGalleryActivity.class, QZAlbumxTabPicLayerFragment.class, bundle, 0, 128, null);
            return;
        }
        RFWLog.d("QZAlbumxGalleryNativeLauncher", RFWLog.USR, "launchTabPicGallery fail, layerLaunchBean: " + layerLaunchBean + ", activity: " + activity);
    }
}

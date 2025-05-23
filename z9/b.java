package z9;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.publish.business.task.IQueueTask;
import com.qzone.publish.business.task.groupalbum.GroupAlbumReshipAlbumTask;
import com.qzone.publish.ui.model.MediaWrapper;
import com.qzone.reborn.groupalbum.reship.manager.GroupAlbumReshipSendBoxManager;
import com.qzone.reborn.widget.QZoneSwipeMenuLayout;
import com.qzone.util.image.ImageInfo;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b extends y9.b {
    private static final int E = cx.a(8.0f);
    private View C;
    private GroupAlbumReshipAlbumTask D;

    /* renamed from: m, reason: collision with root package name */
    private QZoneSwipeMenuLayout f452176m;

    private void z() {
        View view = this.C;
        if (view != null && view.getResources() != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setColor(this.C.getResources().getColor(R.color.qui_common_feedback_error));
            int i3 = E;
            float[] fArr = {0.0f, i3, i3, 0.0f};
            float f16 = fArr[1];
            float f17 = fArr[2];
            float f18 = fArr[3];
            gradientDrawable.setCornerRadii(new float[]{0.0f, fArr[0], f16, f16, f17, f17, f18, f18});
            this.C.setBackground(gradientDrawable);
            return;
        }
        QLog.e("CommonReshipQueueDeleteSection", 1, "[updateMenuDelBgDrawable] mMenuDel or resource is null");
    }

    @Override // y9.b, android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null && view.getId() == R.id.mgv) {
            this.f452176m.g();
            ArrayList<MediaWrapper> mediaWrapperList = this.D.params.getMediaWrapperList();
            if (mediaWrapperList.size() > 0) {
                ImageInfo imageInfo = mediaWrapperList.get(0).getImageInfo();
                ShuoshuoVideoInfo videoInfo = mediaWrapperList.get(0).getVideoInfo();
                if (imageInfo != null) {
                    Object obj = imageInfo.mExtraData.get("mediaId");
                    Objects.requireNonNull(obj);
                    str = obj.toString();
                } else if (videoInfo != null) {
                    Object obj2 = videoInfo.extraInfo.get("mediaId");
                    Objects.requireNonNull(obj2);
                    str = obj2.toString();
                } else {
                    str = "";
                }
                QLog.e("CommonReshipQueueDeleteSection", 1, "[onClick] mediaId:" + str);
                if (!str.isEmpty()) {
                    GroupAlbumReshipSendBoxManager.f56848a.u(this.D.params.getGroupId(), str, true);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // y9.b, com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View view) {
        super.onInitView(view);
        this.f452176m = (QZoneSwipeMenuLayout) this.mRootView.findViewById(R.id.nga);
        this.C = this.mRootView.findViewById(R.id.mgv);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // y9.b, com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.n5y};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // y9.b, com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: x */
    public void onBindData(IQueueTask iQueueTask, int i3, List<Object> list) {
        if (iQueueTask == null) {
            QLog.e("CommonReshipQueueDeleteSection", 1, "[onBindData] data is empty");
        } else if (!(iQueueTask instanceof GroupAlbumReshipAlbumTask)) {
            QLog.e("CommonReshipQueueDeleteSection", 1, "[onBindData] data not correct");
        } else {
            this.D = (GroupAlbumReshipAlbumTask) iQueueTask;
            z();
        }
    }
}

package y50;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.immersive.album.event.QCircleAlbumHideShareEvent;
import com.tencent.biz.qqcircle.immersive.layer.biz.inside.album.QFSLayerAlbumViewModel;
import com.tencent.biz.qqcircle.launcher.c;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StShare;
import java.util.ArrayList;
import java.util.Map;
import qqcircle.QQCircleFeedBase$AlbumPageData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b extends com.tencent.biz.qqcircle.bizparts.b implements View.OnClickListener, SimpleEventReceiver {
    private QFSLayerAlbumViewModel C;

    /* renamed from: d, reason: collision with root package name */
    private final int f449469d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f449470e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f449471f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f449472h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f449473i;

    /* renamed from: m, reason: collision with root package name */
    private FeedCloudMeta$StShare f449474m;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements Observer<QQCircleFeedBase$AlbumPageData> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(QQCircleFeedBase$AlbumPageData qQCircleFeedBase$AlbumPageData) {
            if (!b.this.D9(qQCircleFeedBase$AlbumPageData)) {
                b.this.C9(qQCircleFeedBase$AlbumPageData);
            }
        }
    }

    public b(int i3) {
        this.f449469d = i3;
    }

    private void B9() {
        boolean z16;
        QQCircleFeedBase$AlbumPageData value = this.C.O2().getValue();
        if (value != null) {
            Activity activity = getActivity();
            String valueOf = String.valueOf(value.album.f398441id.get());
            if (value.album.status.get() == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            c.o0(activity, uq3.c.p3(valueOf, z16), null, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C9(QQCircleFeedBase$AlbumPageData qQCircleFeedBase$AlbumPageData) {
        if (qQCircleFeedBase$AlbumPageData == null) {
            return;
        }
        this.f449474m = qQCircleFeedBase$AlbumPageData.share_info.get();
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        if (QCirclePluginUtil.isOwner(qQCircleFeedBase$AlbumPageData.album.owner.f398463id.get())) {
            this.f449472h.setImageDrawable(QCircleSkinHelper.getInstance().getDrawable(R.drawable.qui_more));
            VideoReport.setElementId(this.f449472h, "em_xsj_more_button");
        } else {
            VideoReport.setElementId(this.f449472h, "em_xsj_share_button");
        }
        VideoReport.setElementParams(this.f449472h, buildElementParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean D9(QQCircleFeedBase$AlbumPageData qQCircleFeedBase$AlbumPageData) {
        boolean z16;
        int i3 = 0;
        boolean z17 = true;
        if (qQCircleFeedBase$AlbumPageData.album.status.get() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean isOwner = QCirclePluginUtil.isOwner(qQCircleFeedBase$AlbumPageData.album.owner.f398463id.get());
        if (!z16 || isOwner) {
            z17 = false;
        }
        ImageView imageView = this.f449472h;
        if (z17) {
            i3 = 8;
        }
        imageView.setVisibility(i3);
        return z17;
    }

    private void E9() {
        if (this.f449474m == null) {
            return;
        }
        QCircleShareInfo qCircleShareInfo = new QCircleShareInfo();
        qCircleShareInfo.type = 7;
        QQCircleFeedBase$AlbumPageData value = this.C.O2().getValue();
        if (value != null) {
            qCircleShareInfo.isShowDeleteAndEditAlbum = QCirclePluginUtil.isOwner(value.album.owner.f398463id.get());
            qCircleShareInfo.albumId = value.album.f398441id.get();
            qCircleShareInfo.albumStatus = value.album.status.get();
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
        feedCloudMeta$StFeed.share.set(this.f449474m);
        qCircleShareInfo.feed = feedCloudMeta$StFeed;
        qCircleShareInfo.feedBlockData = new e30.b(feedCloudMeta$StFeed);
        qCircleShareInfo.shareStyleType = 6;
        broadcastMessage("share_action_show_share_sheet", qCircleShareInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onInitView$0(Boolean bool) {
        int i3;
        QQCircleFeedBase$AlbumPageData value = this.C.O2().getValue();
        if (value != null) {
            boolean z16 = true;
            int i16 = 0;
            if (value.album.status.get() != 1) {
                z16 = false;
            }
            if (!z16) {
                ImageView imageView = this.f449472h;
                if (bool.booleanValue()) {
                    i3 = 8;
                } else {
                    i3 = 0;
                }
                imageView.setVisibility(i3);
                ImageView imageView2 = this.f449473i;
                if (!bool.booleanValue()) {
                    i16 = 8;
                }
                imageView2.setVisibility(i16);
            }
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<?>> getEventClass() {
        ArrayList<Class<?>> arrayList = new ArrayList<>();
        arrayList.add(QCircleAlbumHideShareEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPersonalAlbumTitlePart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f165970y94) {
            E9();
        } else if (view.getId() == R.id.du6) {
            if (!getPartManager().onBackEvent() && getActivity() != null) {
                getActivity().finish();
            }
        } else if (view.getId() == R.id.y2m) {
            B9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f449470e = (TextView) view.findViewById(R.id.kbs);
        ImageView imageView = (ImageView) view.findViewById(R.id.du6);
        this.f449471f = imageView;
        imageView.setOnClickListener(this);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.f165970y94);
        this.f449472h = imageView2;
        imageView2.setOnClickListener(this);
        if (this.f449469d == 0) {
            this.f449470e.setVisibility(0);
            this.f449470e.setText(view.getResources().getString(R.string.f181483dw));
            this.f449472h.setVisibility(4);
        }
        ImageView imageView3 = (ImageView) view.findViewById(R.id.y2m);
        this.f449473i = imageView3;
        imageView3.setOnClickListener(this);
        QFSLayerAlbumViewModel qFSLayerAlbumViewModel = (QFSLayerAlbumViewModel) getViewModel(QFSLayerAlbumViewModel.class);
        this.C = qFSLayerAlbumViewModel;
        qFSLayerAlbumViewModel.O2().observe(getHostFragment(), new a());
        this.C.S2().observe(getHostFragment(), new Observer() { // from class: y50.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                b.this.lambda$onInitView$0((Boolean) obj);
            }
        });
        VideoReport.setElementId(this.f449473i, "em_xsj_edit_album_button");
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCircleAlbumHideShareEvent) {
            this.f449472h.setVisibility(8);
        }
    }
}

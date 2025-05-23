package xb0;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import java.net.URLEncoder;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class i extends QCircleBaseShareOperation {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeed f447708d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ClipboardManager f447709e;

        a(FeedCloudMeta$StFeed feedCloudMeta$StFeed, ClipboardManager clipboardManager) {
            this.f447708d = feedCloudMeta$StFeed;
            this.f447709e = clipboardManager;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            ClipboardMonitor.setPrimaryClip(this.f447709e, ClipData.newPlainText("Label", i.this.O(this.f447708d)));
            QCircleToast.h(R.string.f189303z1, 0);
            dialogInterface.dismiss();
        }
    }

    public i(QCircleBaseShareOperation.a aVar) {
        super(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String O(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        Uri.Builder buildUpon = Uri.parse("mqqapi://qcircle/openfolder?tabtype=6&is_force_jump_tab_page=1&sourcetype=75&xsj_main_entrance=push").buildUpon();
        buildUpon.appendQueryParameter("key_forced_inserted_feed_id", feedCloudMeta$StFeed.f398449id.get());
        buildUpon.appendQueryParameter("open_folder_first", "1");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("author", feedCloudMeta$StFeed.poster.f398463id.get());
            jSONObject.put("feedType", feedCloudMeta$StFeed.type.get());
            buildUpon.appendQueryParameter("transdata", URLEncoder.encode(jSONObject.toString(), "UTF-8"));
        } catch (Exception e16) {
            QLog.e("QFSSharePart", 1, "generateFolderFeedSchema error:" + e16);
        }
        buildUpon.appendQueryParameter("feedid", feedCloudMeta$StFeed.f398449id.get());
        buildUpon.appendQueryParameter("createtime", String.valueOf(feedCloudMeta$StFeed.createTime.get()));
        buildUpon.appendQueryParameter("play_url", feedCloudMeta$StFeed.video.playUrl.get());
        buildUpon.appendQueryParameter(QCircleSchemeAttr.Detail.COVER_PIC_URL, feedCloudMeta$StFeed.cover.picUrl.get());
        buildUpon.appendQueryParameter(QCircleSchemeAttr.Detail.V_WIDTH, String.valueOf(feedCloudMeta$StFeed.video.width.get()));
        buildUpon.appendQueryParameter(QCircleSchemeAttr.Detail.V_HEIGHT, String.valueOf(feedCloudMeta$StFeed.video.height.get()));
        buildUpon.appendQueryParameter("uin", feedCloudMeta$StFeed.poster.f398463id.get());
        buildUpon.appendQueryParameter("type", String.valueOf(feedCloudMeta$StFeed.type.get()));
        return buildUpon.toString();
    }

    private String P(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        Uri.Builder buildUpon = Uri.parse("mqqapi://qcircle/opendetail?is_feed_detail=1&sourcetype=75&getfeedlist=1&xsj_main_entrance=push").buildUpon();
        buildUpon.appendQueryParameter("feedid", feedCloudMeta$StFeed.f398449id.get());
        buildUpon.appendQueryParameter("createtime", String.valueOf(feedCloudMeta$StFeed.createTime.get()));
        buildUpon.appendQueryParameter("play_url", feedCloudMeta$StFeed.video.playUrl.get());
        buildUpon.appendQueryParameter(QCircleSchemeAttr.Detail.COVER_PIC_URL, feedCloudMeta$StFeed.cover.picUrl.get());
        buildUpon.appendQueryParameter(QCircleSchemeAttr.Detail.V_WIDTH, String.valueOf(feedCloudMeta$StFeed.video.width.get()));
        buildUpon.appendQueryParameter(QCircleSchemeAttr.Detail.V_HEIGHT, String.valueOf(feedCloudMeta$StFeed.video.height.get()));
        buildUpon.appendQueryParameter("uin", feedCloudMeta$StFeed.poster.f398463id.get());
        buildUpon.appendQueryParameter("type", String.valueOf(feedCloudMeta$StFeed.type.get()));
        return buildUpon.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Q(FeedCloudMeta$StFeed feedCloudMeta$StFeed, ClipboardManager clipboardManager, DialogInterface dialogInterface, int i3) {
        ClipboardMonitor.setPrimaryClip(clipboardManager, ClipData.newPlainText("Label", feedCloudMeta$StFeed.share.url.get()));
        QCircleToast.h(R.string.f182053ff, 0);
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(FeedCloudMeta$StFeed feedCloudMeta$StFeed, ClipboardManager clipboardManager, DialogInterface dialogInterface, int i3) {
        ClipboardMonitor.setPrimaryClip(clipboardManager, ClipData.newPlainText("Label", P(feedCloudMeta$StFeed)));
        QCircleToast.h(R.string.f189303z1, 0);
        dialogInterface.dismiss();
    }

    private void S(final ClipboardManager clipboardManager, final FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (clipboardManager != null && feedCloudMeta$StFeed != null) {
            DialogUtil.createVerticalThreeBtnDialog(f(), 0, "", "\u8bf7\u9009\u62e9\u590d\u5236\u7c7b\u578b", "\u5206\u4eaburl", "\u6d6e\u5c42\u9875\u7b80\u5316feed schema", "\u5e7f\u573a\u9875\u7b80\u5316feed schema", new DialogInterface.OnClickListener() { // from class: xb0.g
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    i.Q(FeedCloudMeta$StFeed.this, clipboardManager, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: xb0.h
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    i.this.R(feedCloudMeta$StFeed, clipboardManager, dialogInterface, i3);
                }
            }, new a(feedCloudMeta$StFeed, clipboardManager)).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    public void G() {
        QCircleShareInfo t16 = t();
        if (t16 != null && t16.feed != null) {
            ClipboardManager clipboardManager = (ClipboardManager) RFWApplication.getApplication().getSystemService("clipboard");
            if (t16.type == 1) {
                if (TextUtils.isEmpty(t16.feed.share.shareWebInfo.shortURL.get())) {
                    QCircleToast.h(R.string.f189293z0, 0);
                    return;
                }
                ClipboardMonitor.setPrimaryClip(clipboardManager, ClipData.newPlainText("personalUrl", t16.feed.share.shareWebInfo.shortURL.get()));
                QCircleToast.h(R.string.f189303z1, 0);
                d(WinkDaTongReportConstant.ElementParamValue.XSJ_SHARE_COPY_LINK, null);
                return;
            }
            if (!TextUtils.isEmpty(t16.feed.share.url.get())) {
                S(clipboardManager, t16.feed);
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    protected boolean y() {
        return true;
    }
}

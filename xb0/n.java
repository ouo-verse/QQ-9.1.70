package xb0;

import android.content.DialogInterface;
import com.tencent.biz.qqcircle.events.QCircleAlbumEvent;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QCircleDeleteAlbumRequest;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Map;
import qqcircle.QQCircleFeedAlbum$DeleteAlbumRsp;

/* compiled from: P */
/* loaded from: classes5.dex */
public class n extends QCircleBaseShareOperation {

    /* renamed from: u, reason: collision with root package name */
    public static final String f447713u = "xb0.n";

    public n(QCircleBaseShareOperation.a aVar) {
        super(aVar);
    }

    private void N() {
        VSNetworkHelper.getInstance().sendRequest(new QCircleDeleteAlbumRequest(t().albumId), O());
    }

    private VSDispatchObserver.OnVSRspCallBack<QQCircleFeedAlbum$DeleteAlbumRsp> O() {
        return new VSDispatchObserver.OnVSRspCallBack() { // from class: xb0.m
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                n.this.Q(baseRequest, z16, j3, str, (QQCircleFeedAlbum$DeleteAlbumRsp) obj);
            }
        };
    }

    private DialogInterface.OnClickListener P() {
        return new DialogInterface.OnClickListener() { // from class: xb0.l
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                n.this.R(dialogInterface, i3);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleFeedAlbum$DeleteAlbumRsp qQCircleFeedAlbum$DeleteAlbumRsp) {
        if (z16 && j3 == 0) {
            String str2 = f447713u;
            QLog.d(str2, 1, "deleteFeed  success | traceId:" + baseRequest.getTraceId());
            try {
                SimpleEventBus.getInstance().dispatchEvent(new QCircleAlbumEvent(1, ((QCircleDeleteAlbumRequest) baseRequest).getRequest().album_id.get()));
                QLog.e(str2, 1, "deleteAlbum  error | traceId:" + baseRequest.getTraceId());
                QCircleToast.o(f().getResources().getString(R.string.f181463du), 0);
                return;
            } catch (Exception e16) {
                QLog.e(f447713u, 1, "send QCircleAlbumEvent failed:" + e16.getMessage());
                return;
            }
        }
        QLog.e(f447713u, 1, "deleteAlbum  error | traceId:" + baseRequest.getTraceId());
        QCircleToast.o(f().getResources().getString(R.string.f181443ds), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(DialogInterface dialogInterface, int i3) {
        if (i3 == 1) {
            N();
            S(QCircleDaTongConstant.ElementId.EM_XSJ_ALBUM_DETAIL_DELETE_BUTTON);
        } else if (i3 == 0) {
            S(QCircleDaTongConstant.ElementId.EM_XSJ_ALBUM_DETAIL_CANCEL_BUTTON);
        }
    }

    private void S(String str) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", str);
        VideoReport.reportEvent("ev_xsj_abnormal_clck", buildElementParams);
    }

    private void T() {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_ALBUM_DETAIL_DELETE_WINDOWS);
        VideoReport.reportEvent("ev_xsj_abnormal_clck", buildElementParams);
    }

    private void U(DialogInterface.OnClickListener onClickListener) {
        if (onClickListener != null && f() != null && !f().isFinishing()) {
            QCircleCustomDialog.S(f(), null, com.tencent.biz.qqcircle.utils.h.a(R.string.f181453dt), R.string.cancel, R.string.f181433dr, onClickListener, onClickListener).show();
            T();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    public void G() {
        if (t() != null && t().feed != null && f() != null) {
            U(P());
            e("delete", null, QCircleDaTongConstant.ElementId.EM_XSJ_ALBUM_SHAREPANEL);
        } else {
            J(f447713u);
        }
    }

    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    protected boolean y() {
        return false;
    }
}

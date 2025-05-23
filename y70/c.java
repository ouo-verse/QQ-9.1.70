package y70;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.feed.cm;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.Iterator;
import qqcircle.QQCircleDitto$StItemInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c extends cm<QQCircleDitto$StItemInfo> implements com.tencent.biz.qqcircle.immersive.scrollers.a {
    @Override // com.tencent.biz.qqcircle.immersive.scrollers.a
    public void a() {
        Iterator<String> it = this.f86069d.keySet().iterator();
        while (it.hasNext()) {
            QFSBaseFeedChildPresenter qFSBaseFeedChildPresenter = (QFSBaseFeedChildPresenter) this.f86069d.get(it.next());
            if (qFSBaseFeedChildPresenter instanceof a) {
                ((a) qFSBaseFeedChildPresenter).a();
            }
        }
    }

    public void e() {
        Iterator<String> it = this.f86069d.keySet().iterator();
        while (it.hasNext()) {
            QFSBaseFeedChildPresenter qFSBaseFeedChildPresenter = (QFSBaseFeedChildPresenter) this.f86069d.get(it.next());
            if (qFSBaseFeedChildPresenter != null) {
                qFSBaseFeedChildPresenter.K0();
            }
        }
    }

    public void f(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo, int i3) {
        Iterator<String> it = this.f86069d.keySet().iterator();
        while (it.hasNext()) {
            QFSBaseFeedChildPresenter qFSBaseFeedChildPresenter = (QFSBaseFeedChildPresenter) this.f86069d.get(it.next());
            if (qFSBaseFeedChildPresenter != null) {
                long currentTimeMillis = System.currentTimeMillis();
                qFSBaseFeedChildPresenter.L0(qQCircleDitto$StItemInfo, i3);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (currentTimeMillis2 > 0 && (QLog.isColorLevel() || QCircleApplication.isRDMVersion())) {
                    QLog.d("QFSMixFeedRecommendPresenterManger_" + qFSBaseFeedChildPresenter.getTAG(), 1, "onBindData:", Long.valueOf(currentTimeMillis2), "ms");
                }
            }
        }
    }

    public void g() {
        Iterator<String> it = this.f86069d.keySet().iterator();
        while (it.hasNext()) {
            QFSBaseFeedChildPresenter qFSBaseFeedChildPresenter = (QFSBaseFeedChildPresenter) this.f86069d.get(it.next());
            if (qFSBaseFeedChildPresenter != null) {
                qFSBaseFeedChildPresenter.M0();
            }
        }
    }

    public void h(View view) {
        Iterator<String> it = this.f86069d.keySet().iterator();
        while (it.hasNext()) {
            QFSBaseFeedChildPresenter qFSBaseFeedChildPresenter = (QFSBaseFeedChildPresenter) this.f86069d.get(it.next());
            if (qFSBaseFeedChildPresenter != null) {
                long currentTimeMillis = System.currentTimeMillis();
                qFSBaseFeedChildPresenter.N0(view);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (currentTimeMillis2 > 0 && (QLog.isColorLevel() || QCircleApplication.isRDMVersion())) {
                    QLog.d("QFSMixFeedRecommendPresenterManger_" + qFSBaseFeedChildPresenter.getTAG(), 1, "onInitView:", Long.valueOf(currentTimeMillis2), "ms");
                }
            }
        }
    }

    public void i(Serializable serializable) {
        Iterator<String> it = this.f86069d.keySet().iterator();
        while (it.hasNext()) {
            QFSBaseFeedChildPresenter qFSBaseFeedChildPresenter = (QFSBaseFeedChildPresenter) this.f86069d.get(it.next());
            if (qFSBaseFeedChildPresenter instanceof a) {
                qFSBaseFeedChildPresenter.U0((QCircleExtraTypeInfo) serializable);
            }
        }
    }

    public void j(ViewGroup viewGroup) {
        Iterator<String> it = this.f86069d.keySet().iterator();
        while (it.hasNext()) {
            QFSBaseFeedChildPresenter qFSBaseFeedChildPresenter = (QFSBaseFeedChildPresenter) this.f86069d.get(it.next());
            if (qFSBaseFeedChildPresenter != null) {
                qFSBaseFeedChildPresenter.X0(viewGroup);
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.scrollers.a
    public void pause() {
        Iterator<String> it = this.f86069d.keySet().iterator();
        while (it.hasNext()) {
            QFSBaseFeedChildPresenter qFSBaseFeedChildPresenter = (QFSBaseFeedChildPresenter) this.f86069d.get(it.next());
            if (qFSBaseFeedChildPresenter instanceof a) {
                ((a) qFSBaseFeedChildPresenter).pause();
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.scrollers.a
    public void play() {
        Iterator<String> it = this.f86069d.keySet().iterator();
        while (it.hasNext()) {
            QFSBaseFeedChildPresenter qFSBaseFeedChildPresenter = (QFSBaseFeedChildPresenter) this.f86069d.get(it.next());
            if (qFSBaseFeedChildPresenter instanceof a) {
                ((a) qFSBaseFeedChildPresenter).play();
            }
        }
    }
}

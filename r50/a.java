package r50;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.adapter.m;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.biz.richframework.video.rfw.drive.RFWLayerBaseScroller;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends RFWLayerBaseScroller implements p60.a {

    /* renamed from: a, reason: collision with root package name */
    private final m f430747a;

    /* renamed from: b, reason: collision with root package name */
    private e30.b f430748b;

    /* renamed from: c, reason: collision with root package name */
    private int f430749c;

    /* renamed from: d, reason: collision with root package name */
    private final ArrayList<String> f430750d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    private final List<InterfaceC11114a> f430751e = new CopyOnWriteArrayList();

    /* renamed from: f, reason: collision with root package name */
    private long f430752f;

    /* compiled from: P */
    /* renamed from: r50.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC11114a {
        void a(e30.b bVar);
    }

    public a(@NonNull m mVar) {
        this.f430747a = mVar;
    }

    private void d(e30.b bVar) {
        if (bVar != null && bVar.g() != null) {
            QLog.d("FeedLine_QFSLayerExposeScroller", 1, "[onNewFeedExpose] feedId:" + bVar.g().f398449id.get());
            for (int i3 = 0; i3 < this.f430751e.size(); i3++) {
                InterfaceC11114a interfaceC11114a = this.f430751e.get(i3);
                if (interfaceC11114a != null) {
                    interfaceC11114a.a(bVar);
                }
            }
        }
    }

    @Override // p60.a
    public int a() {
        return this.f430749c;
    }

    @Override // p60.a
    public e30.b b() {
        return this.f430748b;
    }

    @Override // p60.a
    public boolean c(@NonNull e30.b bVar) {
        return this.f430750d.contains(bVar.g().f398449id.get());
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.RFWLayerBaseScroller
    public void onDataRefresh() {
        super.onDataRefresh();
        QLog.d("FeedLine_QFSLayerExposeScroller", 1, "[onDataRefresh]");
        this.f430748b = null;
        this.f430750d.clear();
        this.f430752f = System.currentTimeMillis();
        this.f430749c = 0;
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.RFWLayerBaseScroller
    public void onSelected(RFWFeedSelectInfo rFWFeedSelectInfo, RecyclerView.ViewHolder viewHolder) {
        e30.b bVar;
        super.onSelected(rFWFeedSelectInfo, viewHolder);
        int position = rFWFeedSelectInfo.getPosition();
        if (!ab0.a.a(position, this.f430747a.getDataList()) && (bVar = this.f430747a.getDataList().get(position)) != null && bVar.g() != null) {
            QLog.d("FeedLine_QFSLayerExposeScroller", 1, "[onSelected] feedId:" + bVar.g().f398449id.get() + ",pos:" + position);
            if (!c(bVar)) {
                d(bVar);
            }
            this.f430749c = position;
            this.f430748b = bVar;
            this.f430750d.add(bVar.g().f398449id.get());
        }
    }
}

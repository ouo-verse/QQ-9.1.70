package y9;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.qzone.publish.business.task.IQueueTask;
import com.qzone.publish.business.task.c;
import com.qzone.reborn.albumx.common.viewmodel.k;
import com.qzone.reborn.base.l;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.qzone.widget.PercentProgressBar;
import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.List;
import l9.h;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends l<IQueueTask> implements View.OnClickListener {
    private PercentProgressBar C;
    private ImageView D;
    private k E;

    /* renamed from: e, reason: collision with root package name */
    private c f449568e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f449569f;

    /* renamed from: h, reason: collision with root package name */
    private RoundCornerImageView f449570h;

    /* renamed from: i, reason: collision with root package name */
    private QZoneRichTextView f449571i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f449572m;

    private void A() {
        k y16 = y();
        if (y16 == null) {
            return;
        }
        y16.P1().observe((LifecycleOwner) p(), new C11596a());
    }

    private String x(IQueueTask iQueueTask, c cVar) {
        String str = "";
        if (cVar != null && !TextUtils.isEmpty(cVar.f51192h)) {
            try {
                File file = new File(cVar.f51192h);
                if (file.exists() && !file.isDirectory()) {
                    str = cVar.f51192h;
                }
            } catch (Throwable th5) {
                QLog.e(getLogTag(), 1, "[getCoverImageUrl] find file fail, error: ", th5);
            }
        }
        return (!TextUtils.isEmpty(str) || iQueueTask == null) ? str : iQueueTask.getPhotoSource();
    }

    private k y() {
        k kVar = this.E;
        if (kVar != null) {
            return kVar;
        }
        h hVar = (h) q(h.class);
        if (hVar == null || hVar.g5() == null) {
            return null;
        }
        k g56 = hVar.g5();
        this.E = g56;
        return g56;
    }

    private void z(View view) {
        QLog.d(getLogTag(), 1, "[handleOpeIconClick]  | taskId=" + ((IQueueTask) this.mData).getTaskId() + " | clientKey=" + ((IQueueTask) this.mData).getClientKey() + " | caseId=" + ((IQueueTask) this.mData).getCaseId());
        k y16 = y();
        if (y16 != null) {
            y16.W1((IQueueTask) this.mData);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void onBindData(IQueueTask iQueueTask, int i3, List<Object> list) {
        A();
        C(iQueueTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public String getLogTag() {
        return "QZPublishX_CommonPublishQueueContentSection";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null && view.getId() == R.id.ngm) {
            z(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: y9.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public class C11596a implements Observer<IQueueTask> {
        C11596a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(IQueueTask iQueueTask) {
            if (iQueueTask == null || ((Section) a.this).mData == null || iQueueTask.getTaskId() != ((IQueueTask) ((Section) a.this).mData).getTaskId()) {
                return;
            }
            a.this.C(iQueueTask);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.n5x};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(IQueueTask iQueueTask) {
        if (iQueueTask != null && iQueueTask.getInfo() != null) {
            c info = iQueueTask.getInfo();
            this.f449568e = info;
            if (info.f51193i) {
                this.f449569f.setVisibility(0);
            } else {
                this.f449569f.setVisibility(8);
            }
            com.tencent.mobileqq.qzone.picload.c.a().h(Option.obtain().setUrl(x(iQueueTask, this.f449568e)).setTargetView(this.f449570h).setLoadingDrawableId(R.drawable.asd).setFailedDrawableId(R.drawable.asd));
            this.f449571i.setRichText(this.f449568e.f51185a);
            this.f449572m.setText(this.f449568e.f51186b);
            c cVar = this.f449568e;
            int i3 = cVar.f51187c;
            if (i3 != 0 && i3 != 4 && i3 != 1 && i3 != 6) {
                this.C.setVisibility(4);
            } else {
                int i16 = cVar.f51190f;
                if (i16 > 0) {
                    this.C.setProgress(i16);
                    this.C.setVisibility(0);
                } else {
                    this.C.setVisibility(4);
                }
            }
            if (iQueueTask.getState() == 2) {
                this.D.setVisibility(0);
            } else {
                this.D.setVisibility(8);
            }
            fo.c.o(this.D, "em_qz_upload_continue", new fo.b().i(String.valueOf(iQueueTask.getTaskId())));
            return;
        }
        QLog.e(getLogTag(), 1, "[onBindData] queueTask or queueInfo is null");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View view) {
        this.f449569f = (ImageView) view.findViewById(R.id.lvx);
        RoundCornerImageView roundCornerImageView = (RoundCornerImageView) view.findViewById(R.id.ngk);
        this.f449570h = roundCornerImageView;
        roundCornerImageView.setCorner(cx.a(4.0f));
        this.f449571i = (QZoneRichTextView) view.findViewById(R.id.ngo);
        this.f449572m = (TextView) view.findViewById(R.id.ngl);
        this.C = (PercentProgressBar) view.findViewById(R.id.ngn);
        ImageView imageView = (ImageView) view.findViewById(R.id.ngm);
        this.D = imageView;
        imageView.setOnClickListener(this);
    }
}

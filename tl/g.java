package tl;

import NS_MOBILE_OPERATION.PicInfo;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.ListAdapter;
import androidx.lifecycle.Observer;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.preview.service.base.PictureConst;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.reborn.base.k;
import com.qzone.reborn.layer.event.QZoneUploadDeleteMediaEvent;
import com.qzone.reborn.part.publish.common.mediapick.QZoneMediaPickInfo;
import com.qzone.reborn.util.l;
import com.qzone.util.ag;
import com.qzone.widget.ExtendGridView;
import com.qzone.widget.dynamicgridview.DynamicArrayList;
import com.qzone.widget.dynamicgridview.DynamicGridView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.widget.AdapterView;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.QZonePermission;
import e9.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes36.dex */
public class g extends k implements IObserver.main, SimpleEventReceiver<QZoneUploadDeleteMediaEvent> {
    private DynamicGridView C;
    protected final tl.a D;

    /* renamed from: e, reason: collision with root package name */
    protected e9.a f436498e;

    /* renamed from: f, reason: collision with root package name */
    public DynamicArrayList<String> f436499f;

    /* renamed from: d, reason: collision with root package name */
    private int f436497d = 0;

    /* renamed from: h, reason: collision with root package name */
    public final DynamicArrayList<String> f436500h = new DynamicArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    public final HashMap<String, LocalMediaInfo> f436501i = new HashMap<>();

    /* renamed from: m, reason: collision with root package name */
    public final HashMap<String, ShuoshuoVideoInfo> f436502m = new HashMap<>();
    private final xk.d E = new xk.d(new a());
    protected a.i F = new b();

    public g(tl.a aVar) {
        this.D = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M9(LocalMediaInfo localMediaInfo, int i3) {
        QZLog.d(getTAG(), 1, "addSelectMediaInfo localMediaInfo is " + localMediaInfo);
        if (localMediaInfo == null) {
            return;
        }
        if (i3 != -1 && this.f436499f.size() >= i3) {
            this.f436499f.add(i3, localMediaInfo.path);
        } else {
            this.f436499f.add(localMediaInfo.path);
        }
        N9(localMediaInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P9(final int i3) {
        this.C.n1(i3, new Runnable() { // from class: tl.e
            @Override // java.lang.Runnable
            public final void run() {
                g.this.aa(i3);
            }
        });
    }

    private void R9(final ShuoshuoVideoInfo shuoshuoVideoInfo) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).post(new Runnable() { // from class: tl.f
            @Override // java.lang.Runnable
            public final void run() {
                g.ba(ShuoshuoVideoInfo.this);
            }
        });
    }

    private void X9() {
        ((h) getViewModel(h.class)).L1().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: tl.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                g.this.ca((QZoneMediaPickInfo) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aa(int i3) {
        QZLog.d(getTAG(), 1, "[deletePhoto]" + i3);
        U9(i3);
        ja();
        this.D.a(this.f436499f, getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void ba(ShuoshuoVideoInfo shuoshuoVideoInfo) {
        String str;
        ag.a r16 = ag.r(shuoshuoVideoInfo.mVideoPath);
        if (r16 != null && (str = r16.f59780a) != null) {
            shuoshuoVideoInfo.mCoverUrl = str;
            QZLog.w("QZoneMediaPickPart", "fullVideoCoverInfo succeed\uff0c videoPath:" + shuoshuoVideoInfo.mVideoPath);
            return;
        }
        QZLog.w("QZoneMediaPickPart", "fullVideoCoverInfo fail, videoPath:" + shuoshuoVideoInfo.mVideoPath);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void da(AdapterView adapterView, View view, int i3, long j3) {
        if (this.f436498e.d0(i3) && this.f436498e.H(view)) {
            if (QZonePermission.requestStoragePermission(getActivity(), QQPermissionConstants.Business.SCENE.QQ_QZONE_SHUOSHUO_ALBUM_OPEN_MEDIA)) {
                ra();
                fo.c.b("dt_clck", this.C, "em_qz_add_pic_video", null);
                return;
            }
            return;
        }
        ia(this.C, i3, this.f436499f, view);
        fo.c.b("dt_clck", this.C, "em_qz_selected_pic", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean ea(View view, MotionEvent motionEvent) {
        if (this.C == null) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            int T9 = T9(motionEvent);
            this.f436497d = T9;
            sa(T9);
        } else if (motionEvent.getAction() == 3) {
            ta(this.f436497d);
        } else if (motionEvent.getAction() == 1) {
            ta(this.f436497d);
        }
        return false;
    }

    private ArrayList<String> ga(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        ArrayList arrayList3 = new ArrayList(arrayList);
        ArrayList<String> arrayList4 = new ArrayList<>();
        int i3 = 0;
        int i16 = 0;
        while (i3 < arrayList3.size() && i16 < arrayList2.size()) {
            String str = (String) arrayList3.get(i3);
            String str2 = arrayList2.get(i16);
            if (!ha(str)) {
                arrayList4.add((String) arrayList3.get(i3));
                i3++;
            } else {
                arrayList4.add(str2);
                i3++;
                i16++;
            }
        }
        while (i3 < arrayList3.size()) {
            String str3 = (String) arrayList3.get(i3);
            if (!ha(str3)) {
                arrayList4.add(str3);
            }
            i3++;
        }
        while (i16 < arrayList2.size()) {
            arrayList4.add(arrayList2.get(i16));
            i16++;
        }
        return arrayList4;
    }

    private void ma() {
        Iterator<Map.Entry<String, LocalMediaInfo>> it = this.f436501i.entrySet().iterator();
        while (it.hasNext()) {
            if (!this.f436499f.contains(it.next().getKey())) {
                it.remove();
            }
        }
        Iterator<Map.Entry<String, ShuoshuoVideoInfo>> it5 = this.f436502m.entrySet().iterator();
        while (it5.hasNext()) {
            if (!this.f436499f.contains(it5.next().getKey())) {
                it5.remove();
            }
        }
        for (int i3 = 0; i3 < this.f436500h.size(); i3++) {
            String str = this.f436500h.get(i3);
            if (!this.f436499f.contains(str)) {
                this.f436500h.remove(str);
            }
        }
    }

    private int oa(LocalMediaInfo localMediaInfo) {
        LocalMediaInfo localMediaInfo2;
        if (this.f436499f.isEmpty()) {
            return -1;
        }
        for (int i3 = 0; i3 < this.f436499f.size(); i3++) {
            String str = this.f436499f.get(i3);
            if (str != null && (localMediaInfo2 = this.f436501i.get(str)) != null && TextUtils.equals(localMediaInfo2.missionID, localMediaInfo.missionID)) {
                this.f436499f.remove(str);
                return i3;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qa(ArrayList<String> arrayList, List<LocalMediaInfo> list) {
        QZLog.d(getTAG(), 1, "addSelectMediaInfos");
        ua(arrayList);
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                LocalMediaInfo localMediaInfo = list.get(i3);
                if (localMediaInfo != null) {
                    N9(localMediaInfo);
                }
            }
        }
        ja();
    }

    private void sa(int i3) {
        DynamicGridView dynamicGridView = this.C;
        if (dynamicGridView == null || i3 < 0 || i3 >= dynamicGridView.getChildCount()) {
            return;
        }
        f6.a.a(this.C.getChildAt(this.f436497d));
    }

    private void ta(int i3) {
        DynamicGridView dynamicGridView = this.C;
        if (dynamicGridView == null || i3 < 0 || i3 >= dynamicGridView.getChildCount()) {
            return;
        }
        f6.a.b(this.C.getChildAt(this.f436497d));
    }

    protected boolean Q9(String str) {
        QZLog.d(getTAG(), 1, "[deletePhoto] path\uff1a" + str);
        if (!this.f436499f.contains(str)) {
            return false;
        }
        this.f436499f.remove(str);
        V9(str);
        ja();
        this.D.a(this.f436499f, getActivity());
        return true;
    }

    protected int S9() {
        return this.D.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void W9() {
        e9.a aVar = new e9.a(getActivity(), this.C, 1000, 1.15f, 0);
        this.f436498e = aVar;
        aVar.x0(true);
        this.f436498e.s0(true);
        this.f436498e.y0(this.F);
        if (this.D.e()) {
            this.f436498e.o0(false, false);
        }
        this.D.m(this.f436498e);
    }

    protected boolean Z9() {
        return true;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<QZoneUploadDeleteMediaEvent>> getEventClass() {
        ArrayList<Class<QZoneUploadDeleteMediaEvent>> arrayList = new ArrayList<>();
        arrayList.add(QZoneUploadDeleteMediaEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneMediaPickPart";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ha(String str) {
        if (!this.D.i() || URLUtil.isNetworkUrl(str) || this.f436500h.contains(str)) {
            return false;
        }
        LocalMediaInfo localMediaInfo = this.f436501i.get(str);
        if (localMediaInfo == null) {
            return true;
        }
        return TextUtils.isEmpty(localMediaInfo.missionID);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        super.handleBroadcastMessage(str, obj);
        if (TextUtils.equals(str, "REFRESH_UPLOAD_PAGE_GRID_LIST")) {
            la();
        }
    }

    protected void ia(ExtendGridView extendGridView, int i3, List<String> list, View view) {
        if (i3 >= this.f436499f.size()) {
            return;
        }
        this.D.k(i3);
        Intent intent = new Intent();
        intent.putExtra("KEY_MEDIA_PLATFORM_TYPE", 1);
        intent.putExtra("PeakConstants.selectedMediaInfoHashMap", this.f436501i);
        if (this.D.g()) {
            intent.putExtra(PictureConst.KEY_EDIT_BTN_TYPE, 1);
        }
        int i16 = !this.D.h() ? 1 : 0;
        l.f59550a.b(list, this.f436501i, this.f436502m);
        com.qzone.common.business.service.b.f().t(getActivity(), extendGridView, i3, list, this.f436501i, this.f436502m, null, null, i16, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ja() {
        e9.a aVar = this.f436498e;
        if (aVar != null) {
            aVar.t0(this.f436499f);
            this.f436498e.v0(this.f436501i);
            this.f436498e.C0(this.f436502m);
            tl.a aVar2 = this.D;
            boolean z16 = aVar2 != null && aVar2.f() && this.f436499f.size() < S9();
            tl.a aVar3 = this.D;
            if (aVar3 != null && aVar3.e()) {
                this.f436498e.o0(false, true);
            } else {
                this.f436498e.o0(z16, true);
            }
            tl.a aVar4 = this.D;
            if (aVar4 != null) {
                aVar4.b(this.C, this.f436498e);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        h hVar = (h) getViewModel(h.class);
        this.f436499f = hVar.P1().getValue();
        hVar.Z1(this.f436500h);
        hVar.a2(this.f436501i);
        hVar.b2(this.f436502m);
        Y9(view);
        X9();
        W9();
        this.C.setAdapter((ListAdapter) this.f436498e);
        Activity activity = getActivity();
        if (activity != null) {
            this.E.a(activity.getIntent());
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onNewIntent(Intent intent) {
        this.E.a(intent);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        EventCenter.getInstance().addUIObserver(this, "Local", 1);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QZoneUploadDeleteMediaEvent) {
            Q9(((QZoneUploadDeleteMediaEvent) simpleBaseEvent).getLocalPath());
        }
    }

    public boolean ra() {
        com.qzone.common.business.service.media.c cVar = new com.qzone.common.business.service.media.c(this.D.d());
        if (cVar.f45832e == null) {
            cVar.f45832e = new Bundle();
        }
        if (getHostFragment() != null) {
            cVar.f45832e.putString("public_origin_fragment_class", getHostFragment().getClass().getName());
        }
        if (getActivity() != null && getActivity().getIntent() != null) {
            Parcelable parcelableExtra = getActivity().getIntent().getParcelableExtra("key_bundle_common_init_bean");
            Serializable serializableExtra = getActivity().getIntent().getSerializableExtra("key_bundle_common_init_bean");
            if (parcelableExtra != null) {
                cVar.f45832e.putParcelable("key_bundle_common_init_bean", parcelableExtra);
            } else if (serializableExtra != null) {
                cVar.f45832e.putSerializable("key_bundle_common_init_bean", serializableExtra);
            }
        }
        if (this.D.i()) {
            cVar.f45830c = new ArrayList<>(this.f436499f);
        } else {
            cVar.f45833f = this.f436499f.size();
        }
        cVar.f45834g = this.D.n();
        this.D.l(cVar, this.C);
        com.qzone.common.business.service.b.f().l(getActivity(), cVar);
        return true;
    }

    protected void ua(ArrayList<String> arrayList) {
        if (!this.D.i()) {
            this.f436499f.addAll(arrayList);
            return;
        }
        ArrayList<String> ga5 = ga(this.f436499f, arrayList);
        this.f436499f.clear();
        this.f436499f.addAll(ga5);
        ma();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public class c implements DynamicGridView.t {
        c() {
        }

        @Override // com.qzone.widget.dynamicgridview.DynamicGridView.t
        public void onEditModeChanged(boolean z16) {
            if (!z16 || g.this.f436498e.e0()) {
                return;
            }
            g.this.f436498e.L(true);
        }
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class a implements xk.a {
        a() {
        }

        @Override // xk.a
        public void a(ArrayList<String> arrayList, List<LocalMediaInfo> list, HashMap<String, PicInfo> hashMap, Intent intent) {
            g.this.qa(arrayList, list);
        }

        @Override // xk.a
        public void d(LocalMediaInfo localMediaInfo, Intent intent) {
            if (localMediaInfo == null) {
                return;
            }
            g.this.f436500h.add(localMediaInfo.path);
            g.this.M9(localMediaInfo, -1);
            g.this.ja();
        }

        @Override // xk.a
        public void c(LocalMediaInfo localMediaInfo, Intent intent) {
            if (localMediaInfo == null || intent == null) {
                return;
            }
            g.this.f436500h.add(localMediaInfo.path);
            if (!intent.getBooleanExtra("needRemoveAllLocalPathWhenExport", false)) {
                g.this.M9(localMediaInfo, g.this.pa(localMediaInfo, intent));
                g.this.ja();
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(localMediaInfo);
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(localMediaInfo.path);
                g.this.qa(arrayList2, arrayList);
            }
        }

        @Override // xk.a
        public void b() {
        }
    }

    private int T9(MotionEvent motionEvent) {
        if (motionEvent == null || this.C == null) {
            return 0;
        }
        return this.C.pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
    }

    private void N9(LocalMediaInfo localMediaInfo) {
        if (localMediaInfo == null) {
            return;
        }
        if (QAlbumUtil.getMediaType(localMediaInfo) == 1 || localMediaInfo.mMediaType == 1) {
            ShuoshuoVideoInfo b16 = ag.b(localMediaInfo);
            this.f436502m.put(localMediaInfo.path, b16);
            if (TextUtils.isEmpty(b16.mCoverUrl)) {
                R9(b16);
            }
        }
        this.f436501i.put(localMediaInfo.path, localMediaInfo);
    }

    private void Y9(View view) {
        DynamicGridView dynamicGridView = (DynamicGridView) view.findViewById(R.id.f69063hq);
        this.C = dynamicGridView;
        dynamicGridView.setNumColumns(3);
        this.C.setTranscriptMode(1);
        this.C.setStretchable(true);
        this.C.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: tl.b
            @Override // com.tencent.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i3, long j3) {
                g.this.da(adapterView, view2, i3, j3);
            }
        });
        this.C.setOnTouchListener(new View.OnTouchListener() { // from class: tl.c
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean ea5;
                ea5 = g.this.ea(view2, motionEvent);
                return ea5;
            }
        });
        this.C.setLetParentInterceptTouchEventAt23(false);
        this.C.setEditModeEnabled(Z9());
        this.C.setOnEditModeChangeListener(new c());
        this.C.setOnDragListener(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ca(QZoneMediaPickInfo qZoneMediaPickInfo) {
        if (qZoneMediaPickInfo == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        HashMap<String, LocalMediaInfo> hashMap = qZoneMediaPickInfo.selectedMediaInfoMap;
        if (hashMap != null) {
            Iterator<Map.Entry<String, LocalMediaInfo>> it = hashMap.entrySet().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getValue());
            }
        }
        QZLog.d(getTAG(), 1, "initFromDraftData mediaList size: " + arrayList.size());
        qa(qZoneMediaPickInfo.selectMediaPathList, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int pa(LocalMediaInfo localMediaInfo, Intent intent) {
        if (intent != null && !intent.getBooleanExtra("needRemoveOriginPath", true)) {
            return -1;
        }
        int oa5 = oa(localMediaInfo);
        if (oa5 != -1) {
            return oa5;
        }
        ArrayList<String> arrayList = localMediaInfo.mOriginPath;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        if (intent != null) {
            String stringExtra = intent.getStringExtra("editFileOriginPath");
            if (!TextUtils.isEmpty(stringExtra)) {
                arrayList.add(stringExtra);
            }
        }
        return na(arrayList);
    }

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        Object[] objArr;
        if (event != null && "Local".equals(event.source.getName()) && event.what == 1 && (objArr = (Object[]) event.params) != null && objArr.length > 0) {
            Q9((String) objArr[0]);
        }
    }

    private int na(ArrayList<String> arrayList) {
        int indexOf;
        if (arrayList == null || this.f436499f.isEmpty()) {
            return -1;
        }
        int i3 = -1;
        for (int i16 = 0; i16 < arrayList.size(); i16++) {
            String str = arrayList.get(i16);
            if (str != null && (indexOf = this.f436499f.indexOf(str)) >= 0 && indexOf < this.f436499f.size()) {
                this.f436499f.remove(str);
                if (i3 == -1) {
                    i3 = indexOf;
                }
                QZLog.d(getTAG(), 1, "removeOriginMergeList remove path:" + str);
            }
        }
        return i3;
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class b extends a.i {
        b() {
        }

        @Override // e9.a.i
        public boolean a() {
            return g.this.f436498e.U() < g.this.S9();
        }

        @Override // e9.a.i
        public boolean b() {
            g.this.ra();
            return true;
        }

        @Override // e9.a.i
        public boolean c(int i3) {
            g.this.P9(i3);
            return true;
        }

        @Override // e9.a.i
        public void e() {
            g.this.O9();
        }

        @Override // e9.a.i
        public void d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O9() {
    }

    protected void la() {
    }

    protected void U9(int i3) {
    }

    protected void V9(String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public class d implements DynamicGridView.s {
        d() {
        }

        @Override // com.qzone.widget.dynamicgridview.DynamicGridView.s
        public void b(int i3, int i16) {
            g.this.D.j(i3);
        }

        @Override // com.qzone.widget.dynamicgridview.DynamicGridView.s
        public void a(int i3, int i16) {
        }
    }
}

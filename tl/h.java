package tl;

import androidx.lifecycle.MutableLiveData;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.reborn.part.publish.common.mediapick.QZoneMediaPickInfo;
import com.qzone.widget.dynamicgridview.DynamicArrayList;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes36.dex */
public class h extends ql.a<QZoneMediaPickInfo> {
    public static final String F = "h";
    private HashMap<String, LocalMediaInfo> C;
    private HashMap<String, ShuoshuoVideoInfo> D;
    private ArrayList<String> E;

    /* renamed from: m, reason: collision with root package name */
    private final MutableLiveData<DynamicArrayList<String>> f436507m = new MutableLiveData<>(new DynamicArrayList());

    @Override // ql.a
    public boolean M1() {
        DynamicArrayList<String> value = this.f436507m.getValue();
        return (value == null || value.isEmpty()) ? false : true;
    }

    public QZoneMediaPickInfo O1() {
        QZoneMediaPickInfo qZoneMediaPickInfo = new QZoneMediaPickInfo();
        DynamicArrayList<String> value = this.f436507m.getValue();
        if (value != null) {
            qZoneMediaPickInfo.selectMediaPathList.addAll(value);
        }
        qZoneMediaPickInfo.selectedMediaInfoMap.putAll(this.C);
        qZoneMediaPickInfo.editImageList.addAll(this.E);
        return qZoneMediaPickInfo;
    }

    public MutableLiveData<DynamicArrayList<String>> P1() {
        return this.f436507m;
    }

    public HashMap<String, LocalMediaInfo> Q1() {
        return this.C;
    }

    public HashMap<String, ShuoshuoVideoInfo> R1() {
        return this.D;
    }

    public boolean U1() {
        return M1();
    }

    public boolean W1() {
        DynamicArrayList<String> value = this.f436507m.getValue();
        if (this.C != null && value != null) {
            if (S1(value)) {
                return true;
            }
            if (!T1(value) && value.size() > 0) {
                return true;
            }
        }
        return false;
    }

    public boolean X1() {
        DynamicArrayList<String> value = this.f436507m.getValue();
        if (this.C == null || value == null) {
            return false;
        }
        return T1(value);
    }

    public void Z1(ArrayList<String> arrayList) {
        this.E = arrayList;
    }

    public void a2(HashMap<String, LocalMediaInfo> hashMap) {
        this.C = hashMap;
    }

    public void b2(HashMap<String, ShuoshuoVideoInfo> hashMap) {
        this.D = hashMap;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return F;
    }

    private boolean S1(DynamicArrayList<String> dynamicArrayList) {
        for (int i3 = 0; i3 < dynamicArrayList.size(); i3++) {
            LocalMediaInfo localMediaInfo = this.C.get(dynamicArrayList.get(i3));
            if (localMediaInfo != null && QAlbumUtil.getMediaType(localMediaInfo) == 0) {
                QZLog.d(F, 2, "has normal pic");
                return true;
            }
        }
        return false;
    }

    private boolean T1(DynamicArrayList<String> dynamicArrayList) {
        for (int i3 = 0; i3 < dynamicArrayList.size(); i3++) {
            LocalMediaInfo localMediaInfo = this.C.get(dynamicArrayList.get(i3));
            if (localMediaInfo != null && QAlbumUtil.getMediaType(localMediaInfo) == 1) {
                QZLog.d(F, 2, "has normal video");
                return true;
            }
        }
        return false;
    }
}

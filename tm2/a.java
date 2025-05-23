package tm2;

import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOBrowserPresenter;
import com.tencent.richmediabrowser.model.MainBrowserModel;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import vm2.SubtitleGuideData;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a extends MainBrowserModel {

    /* renamed from: a, reason: collision with root package name */
    private AIOBrowserPresenter f436597a;

    /* renamed from: b, reason: collision with root package name */
    public RichMediaBrowserInfo f436598b;

    /* renamed from: c, reason: collision with root package name */
    int f436599c;

    /* renamed from: d, reason: collision with root package name */
    int f436600d;

    /* renamed from: e, reason: collision with root package name */
    public SubtitleGuideData f436601e;

    /* renamed from: f, reason: collision with root package name */
    List<RichMediaBrowserInfo> f436602f;

    /* renamed from: g, reason: collision with root package name */
    boolean f436603g;

    /* renamed from: h, reason: collision with root package name */
    boolean f436604h;

    /* renamed from: i, reason: collision with root package name */
    boolean f436605i;

    public a(AIOBrowserPresenter aIOBrowserPresenter) {
        super(aIOBrowserPresenter);
        this.f436601e = new SubtitleGuideData();
        this.f436602f = new ArrayList();
        this.f436603g = false;
        this.f436604h = false;
        this.f436605i = false;
        this.f436597a = aIOBrowserPresenter;
    }

    public static boolean m(AIOBrowserBaseData aIOBrowserBaseData) {
        if (aIOBrowserBaseData == null) {
            return false;
        }
        if (aIOBrowserBaseData.getType() != 100 && aIOBrowserBaseData.getType() != 101 && aIOBrowserBaseData.getType() != 102 && aIOBrowserBaseData.getType() != 103) {
            return false;
        }
        return true;
    }

    public void a(RichMediaBrowserInfo richMediaBrowserInfo, boolean z16) {
        if (n(richMediaBrowserInfo)) {
            if (richMediaBrowserInfo.baseData.getType() == 101) {
                ((AIOVideoData) richMediaBrowserInfo.baseData).I = z16;
            } else if (richMediaBrowserInfo.baseData.getType() == 103) {
                ((AIOFileVideoData) richMediaBrowserInfo.baseData).L = z16;
            }
        }
    }

    public void b(RichMediaBrowserInfo richMediaBrowserInfo, long j3) {
        if (n(richMediaBrowserInfo) && richMediaBrowserInfo.baseData.getType() == 101) {
            ((AIOVideoData) richMediaBrowserInfo.baseData).K = j3;
        }
    }

    public void c(RichMediaBrowserInfo richMediaBrowserInfo) {
        if (n(richMediaBrowserInfo)) {
            if (richMediaBrowserInfo.baseData.getType() == 101) {
                ((AIOVideoData) richMediaBrowserInfo.baseData).J = true;
            } else if (richMediaBrowserInfo.baseData.getType() == 103) {
                ((AIOFileVideoData) richMediaBrowserInfo.baseData).M = true;
            }
        }
    }

    public List<RichMediaBrowserInfo> d(List<RichMediaBrowserInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (RichMediaBrowserInfo richMediaBrowserInfo : list) {
                if (m((AIOBrowserBaseData) richMediaBrowserInfo.baseData)) {
                    arrayList.add(richMediaBrowserInfo);
                }
            }
        }
        return arrayList;
    }

    public List<RichMediaBrowserInfo> e() {
        return this.browserDataList;
    }

    public RichMediaBrowserInfo f() {
        return this.f436598b;
    }

    public RichMediaBrowserInfo g(long j3) {
        List<RichMediaBrowserInfo> list = this.browserDataList;
        if (list != null) {
            for (RichMediaBrowserInfo richMediaBrowserInfo : list) {
                if (j3 == ((AIOBrowserBaseData) richMediaBrowserInfo.baseData).msgId) {
                    return richMediaBrowserInfo;
                }
            }
            return null;
        }
        return null;
    }

    public RichMediaBrowserInfo h(long j3, long j16) {
        List<RichMediaBrowserInfo> list = this.browserDataList;
        if (list != null) {
            for (RichMediaBrowserInfo richMediaBrowserInfo : list) {
                if (j3 == ((AIOBrowserBaseData) richMediaBrowserInfo.baseData).msgId && j16 == r2.subId) {
                    return richMediaBrowserInfo;
                }
            }
            return null;
        }
        return null;
    }

    public int i(long j3) {
        List<RichMediaBrowserInfo> list = this.browserDataList;
        if (list != null) {
            Iterator<RichMediaBrowserInfo> it = list.iterator();
            while (it.hasNext()) {
                AIOBrowserBaseData aIOBrowserBaseData = (AIOBrowserBaseData) it.next().baseData;
                if (aIOBrowserBaseData != null && j3 == aIOBrowserBaseData.msgId) {
                    return aIOBrowserBaseData.getType();
                }
            }
            return -1;
        }
        return -1;
    }

    public int j(long j3, int i3) {
        List<RichMediaBrowserInfo> list = this.browserDataList;
        if (list != null) {
            Iterator<RichMediaBrowserInfo> it = list.iterator();
            while (it.hasNext()) {
                AIOBrowserBaseData aIOBrowserBaseData = (AIOBrowserBaseData) it.next().baseData;
                if (aIOBrowserBaseData != null && j3 == aIOBrowserBaseData.msgId && i3 == aIOBrowserBaseData.subId) {
                    return aIOBrowserBaseData.getType();
                }
            }
            return -1;
        }
        return -1;
    }

    public int k(long j3, int i3, int i16, String str, String str2) {
        List<RichMediaBrowserInfo> list = this.browserDataList;
        for (int i17 = 0; i17 < list.size(); i17++) {
            RichMediaBrowserInfo richMediaBrowserInfo = list.get(i17);
            if (RichMediaBrowserInfo.class.isInstance(richMediaBrowserInfo)) {
                AIOBrowserBaseData aIOBrowserBaseData = (AIOBrowserBaseData) richMediaBrowserInfo.baseData;
                if (AIOPictureData.class.isInstance(aIOBrowserBaseData)) {
                    AIOPictureData aIOPictureData = (AIOPictureData) aIOBrowserBaseData;
                    if (aIOPictureData.msgId == j3 && aIOPictureData.subId == i3) {
                        new d().g(aIOPictureData, i16, str, str2);
                        return i17;
                    }
                } else if (AIOVideoData.class.isInstance(aIOBrowserBaseData)) {
                    AIOVideoData aIOVideoData = (AIOVideoData) aIOBrowserBaseData;
                    if (aIOVideoData.msgId == j3) {
                        new e().e(aIOVideoData, i16, str);
                        return i17;
                    }
                } else if (AIOFilePictureData.class.isInstance(aIOBrowserBaseData)) {
                    AIOFilePictureData aIOFilePictureData = (AIOFilePictureData) aIOBrowserBaseData;
                    if (aIOFilePictureData.msgId == j3) {
                        new b().g(aIOFilePictureData, i16, str);
                        return i17;
                    }
                } else if (AIOFileVideoData.class.isInstance(aIOBrowserBaseData) && ((AIOFileVideoData) aIOBrowserBaseData).msgId == j3) {
                    return i17;
                }
            }
        }
        return -1;
    }

    public void l(RichMediaBrowserInfo richMediaBrowserInfo) {
        this.browserDataList.clear();
        this.currentIndex = 0;
        this.currentBrowserInfo = richMediaBrowserInfo;
        richMediaBrowserInfo.isEnterImage = true;
        this.f436598b = richMediaBrowserInfo;
        this.browserDataList.add(richMediaBrowserInfo);
    }

    public boolean n(RichMediaBrowserInfo richMediaBrowserInfo) {
        RichMediaBaseData richMediaBaseData;
        if (richMediaBrowserInfo != null && (richMediaBaseData = richMediaBrowserInfo.baseData) != null && (richMediaBaseData.getType() == 101 || richMediaBrowserInfo.baseData.getType() == 103)) {
            return true;
        }
        return false;
    }

    public boolean o() {
        int size;
        if (!this.f436605i || (size = this.f436602f.size()) <= 0) {
            return false;
        }
        this.f436599c += size;
        this.f436600d += size;
        List<RichMediaBrowserInfo> d16 = d(this.f436602f);
        if (this.f436604h) {
            Collections.reverse(d16);
            this.browserDataList.addAll(d16);
        } else {
            this.currentIndex += d16.size();
            this.browserDataList.addAll(0, d16);
        }
        this.f436602f.clear();
        return true;
    }

    public synchronized RichMediaBrowserInfo p(long j3) {
        RichMediaBrowserInfo richMediaBrowserInfo;
        Iterator<RichMediaBrowserInfo> it = this.browserDataList.iterator();
        while (true) {
            if (it.hasNext()) {
                richMediaBrowserInfo = it.next();
                if (((AIOBrowserBaseData) richMediaBrowserInfo.baseData).msgId == j3) {
                    break;
                }
            } else {
                richMediaBrowserInfo = null;
                break;
            }
        }
        if (richMediaBrowserInfo != null) {
            this.browserDataList.remove(richMediaBrowserInfo);
        }
        return richMediaBrowserInfo;
    }

    public void q(boolean z16) {
        if (this.f436604h != z16) {
            this.f436604h = z16;
            Collections.reverse(this.browserDataList);
            this.currentIndex = (this.browserDataList.size() - 1) - this.currentIndex;
        }
    }

    public boolean r(AIOBrowserBaseData[] aIOBrowserBaseDataArr, int i3) {
        ArrayList arrayList = new ArrayList();
        int length = aIOBrowserBaseDataArr.length - 1;
        if (length >= 0) {
            AIOBrowserBaseData aIOBrowserBaseData = aIOBrowserBaseDataArr[length];
            if (this.f436598b == null || this.currentBrowserInfo == null) {
                RichMediaBrowserInfo richMediaBrowserInfo = new RichMediaBrowserInfo();
                richMediaBrowserInfo.baseData = aIOBrowserBaseData;
                this.currentBrowserInfo = richMediaBrowserInfo;
                this.f436598b = richMediaBrowserInfo;
            }
        }
        AIOBrowserBaseData aIOBrowserBaseData2 = (AIOBrowserBaseData) this.f436598b.baseData;
        AIOBrowserBaseData aIOBrowserBaseData3 = (AIOBrowserBaseData) this.currentBrowserInfo.baseData;
        for (AIOBrowserBaseData aIOBrowserBaseData4 : aIOBrowserBaseDataArr) {
            if (this.f436603g) {
                RichMediaBrowserInfo richMediaBrowserInfo2 = new RichMediaBrowserInfo();
                richMediaBrowserInfo2.baseData = aIOBrowserBaseData4;
                arrayList.add(richMediaBrowserInfo2);
            } else {
                long j3 = aIOBrowserBaseData2.msgId;
                long j16 = aIOBrowserBaseData4.msgId;
                if (j3 == j16 && aIOBrowserBaseData2.subId == aIOBrowserBaseData4.subId) {
                    RichMediaBrowserInfo richMediaBrowserInfo3 = this.f436598b;
                    richMediaBrowserInfo3.isEnterImage = true;
                    if (richMediaBrowserInfo3 == this.currentBrowserInfo) {
                        this.f436605i = true;
                    }
                    arrayList.add(richMediaBrowserInfo3);
                } else if (aIOBrowserBaseData3.msgId == j16 && aIOBrowserBaseData3.subId == aIOBrowserBaseData4.subId) {
                    arrayList.add(this.currentBrowserInfo);
                } else {
                    RichMediaBrowserInfo richMediaBrowserInfo4 = new RichMediaBrowserInfo();
                    richMediaBrowserInfo4.baseData = aIOBrowserBaseData4;
                    arrayList.add(richMediaBrowserInfo4);
                }
            }
        }
        if (i3 >= 0) {
            int length2 = aIOBrowserBaseDataArr.length;
        }
        if (this.f436603g) {
            this.f436602f.addAll(0, arrayList);
            return false;
        }
        if (!this.f436605i) {
            return false;
        }
        List<RichMediaBrowserInfo> d16 = d(arrayList);
        this.browserDataList = d16;
        if (this.f436604h) {
            Collections.reverse(d16);
        }
        int indexOf = this.browserDataList.indexOf(this.f436598b);
        this.currentIndex = indexOf;
        if (n(getItem(indexOf))) {
            updateItem(this.currentBrowserInfo, this.currentIndex);
        }
        this.f436603g = true;
        return true;
    }

    public void s(long j3, int i3, int i16) {
        List<RichMediaBrowserInfo> list = this.browserDataList;
        if (list != null) {
            int size = list.size();
            for (int i17 = 0; i17 < size; i17++) {
                AIOBrowserBaseData aIOBrowserBaseData = (AIOBrowserBaseData) this.browserDataList.get(i17).baseData;
                if (j3 == aIOBrowserBaseData.msgId && i3 == aIOBrowserBaseData.subId) {
                    this.browserDataList.get(i17).baseData.updateStatus(i16);
                }
            }
        }
    }

    @Override // com.tencent.richmediabrowser.model.MainBrowserModel
    public void updateItem(RichMediaBrowserInfo richMediaBrowserInfo) {
        List<RichMediaBrowserInfo> list;
        if (richMediaBrowserInfo != null && richMediaBrowserInfo.baseData != null && (list = this.browserDataList) != null) {
            int size = list.size();
            AIOBrowserBaseData aIOBrowserBaseData = (AIOBrowserBaseData) richMediaBrowserInfo.baseData;
            for (int i3 = 0; i3 < size; i3++) {
                AIOBrowserBaseData aIOBrowserBaseData2 = (AIOBrowserBaseData) this.browserDataList.get(i3).baseData;
                if (aIOBrowserBaseData.msgId == aIOBrowserBaseData2.msgId && aIOBrowserBaseData.subId == aIOBrowserBaseData2.subId) {
                    this.browserDataList.set(i3, richMediaBrowserInfo);
                }
            }
        }
    }
}

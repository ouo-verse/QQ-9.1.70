package qz_groupphoto;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes29.dex */
public final class GetLastPicRsp extends JceStruct {
    static Map<String, String> cache_exend;
    static ArrayList<String> cache_vec_picurl;
    public int cnt;
    public Map<String, String> exend;
    public boolean is_new;
    public long nexttime;
    public ArrayList<String> vec_picurl;

    public GetLastPicRsp() {
        this.vec_picurl = null;
        this.is_new = true;
        this.cnt = 0;
        this.nexttime = 0L;
        this.exend = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_vec_picurl == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            cache_vec_picurl = arrayList;
            arrayList.add("");
        }
        this.vec_picurl = (ArrayList) jceInputStream.read((JceInputStream) cache_vec_picurl, 0, true);
        this.is_new = jceInputStream.read(this.is_new, 1, false);
        this.cnt = jceInputStream.read(this.cnt, 2, false);
        this.nexttime = jceInputStream.read(this.nexttime, 3, false);
        if (cache_exend == null) {
            HashMap hashMap = new HashMap();
            cache_exend = hashMap;
            hashMap.put("", "");
        }
        this.exend = (Map) jceInputStream.read((JceInputStream) cache_exend, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.vec_picurl, 0);
        jceOutputStream.write(this.is_new, 1);
        jceOutputStream.write(this.cnt, 2);
        jceOutputStream.write(this.nexttime, 3);
        Map<String, String> map = this.exend;
        if (map != null) {
            jceOutputStream.write((Map) map, 4);
        }
    }

    public GetLastPicRsp(ArrayList<String> arrayList, boolean z16, int i3, long j3, Map<String, String> map) {
        this.vec_picurl = arrayList;
        this.is_new = z16;
        this.cnt = i3;
        this.nexttime = j3;
        this.exend = map;
    }
}

package seal;

import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SealEdgeComputing$ClientItemInfo extends MessageMicro<SealEdgeComputing$ClientItemInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 25, 34, 42, 50}, new String[]{"cate_name", "sub_cate_name", "seal_score", QFSEdgeItem.KEY_EXTEND, "hot_info", "advert_info"}, new Object[]{"", "", Double.valueOf(0.0d), "", "", null}, SealEdgeComputing$ClientItemInfo.class);
    public final PBStringField cate_name = PBField.initString("");
    public final PBStringField sub_cate_name = PBField.initString("");
    public final PBDoubleField seal_score = PBField.initDouble(0.0d);
    public final PBStringField extend = PBField.initString("");
    public final PBStringField hot_info = PBField.initString("");
    public SealEdgeComputing$AdvertInfo advert_info = new SealEdgeComputing$AdvertInfo();
}

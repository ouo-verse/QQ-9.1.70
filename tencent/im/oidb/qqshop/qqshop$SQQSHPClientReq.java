package tencent.im.oidb.qqshop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class qqshop$SQQSHPClientReq extends MessageMicro<qqshop$SQQSHPClientReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field ad_id;
    public final PBRepeatField<Long> cuinlist;
    public final PBUInt32Field eventid = PBField.initUInt32(0);
    public final PBDoubleField latitude;
    public final PBDoubleField longitude;
    public final PBInt32Field msglistlen;
    public final PBRepeatField<Long> puinlist;
    public final PBUInt64Field rcpuin;

    static {
        Double valueOf = Double.valueOf(0.0d);
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 33, 41, 48, 56, 64}, new String[]{"eventid", "puinlist", "cuinlist", "longitude", "latitude", "msglistlen", "rcpuin", "ad_id"}, new Object[]{0, 0L, 0L, valueOf, valueOf, -1, 0L, 0L}, qqshop$SQQSHPClientReq.class);
    }

    public qqshop$SQQSHPClientReq() {
        PBUInt64Field pBUInt64Field = PBUInt64Field.__repeatHelper__;
        this.puinlist = PBField.initRepeat(pBUInt64Field);
        this.cuinlist = PBField.initRepeat(pBUInt64Field);
        this.longitude = PBField.initDouble(0.0d);
        this.latitude = PBField.initDouble(0.0d);
        this.msglistlen = PBField.initInt32(-1);
        this.rcpuin = PBField.initUInt64(0L);
        this.ad_id = PBField.initUInt64(0L);
    }
}

package tencent.im.oidb.olympic;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OlympicTorchSvc$ReqGetTorchAward extends MessageMicro<OlympicTorchSvc$ReqGetTorchAward> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_pack_id;
    public final PBBytesField bytes_sig;
    public final PBRepeatField<Long> rpt_city_pic_id_list;
    public final PBUInt32Field uint32_business;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 82}, new String[]{"bytes_pack_id", "uint32_business", "rpt_city_pic_id_list", "bytes_sig"}, new Object[]{byteStringMicro, 0, 0L, byteStringMicro}, OlympicTorchSvc$ReqGetTorchAward.class);
    }

    public OlympicTorchSvc$ReqGetTorchAward() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_pack_id = PBField.initBytes(byteStringMicro);
        this.uint32_business = PBField.initUInt32(0);
        this.rpt_city_pic_id_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
        this.bytes_sig = PBField.initBytes(byteStringMicro);
    }
}

package unite;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class DynamicSearch$RootSearcherRequest extends MessageMicro<DynamicSearch$RootSearcherRequest> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField cookie;
    public final PBBytesField ocean_data;
    public final PBUInt32Field use_all_mask;
    public final PBUInt32Field business = PBField.initUInt32(0);
    public final PBUInt32Field page_size = PBField.initUInt32(0);
    public final PBRepeatField<Long> rpt_busi_mask = PBField.initRepeat(PBUInt64Field.__repeatHelper__);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{16, 32, 80, 90, 402, 408}, new String[]{"business", "page_size", "rpt_busi_mask", "cookie", "ocean_data", "use_all_mask"}, new Object[]{0, 0, 0L, byteStringMicro, byteStringMicro, 0}, DynamicSearch$RootSearcherRequest.class);
    }

    public DynamicSearch$RootSearcherRequest() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.cookie = PBField.initBytes(byteStringMicro);
        this.ocean_data = PBField.initBytes(byteStringMicro);
        this.use_all_mask = PBField.initUInt32(0);
    }
}

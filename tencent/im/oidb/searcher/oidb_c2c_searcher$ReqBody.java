package tencent.im.oidb.searcher;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_c2c_searcher$ReqBody extends MessageMicro<oidb_c2c_searcher$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"query", "friends", "max_cnt", "type"}, new Object[]{ByteStringMicro.EMPTY, null, 0, 0}, oidb_c2c_searcher$ReqBody.class);
    public final PBBytesField query = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_c2c_searcher$Iterator> friends = PBField.initRepeatMessage(oidb_c2c_searcher$Iterator.class);
    public final PBUInt32Field max_cnt = PBField.initUInt32(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
}

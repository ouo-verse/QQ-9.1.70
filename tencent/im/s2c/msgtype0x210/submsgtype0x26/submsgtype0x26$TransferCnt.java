package tencent.im.s2c.msgtype0x210.submsgtype0x26;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0x26$TransferCnt extends MessageMicro<submsgtype0x26$TransferCnt> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"chain_id"}, new Object[]{0L}, submsgtype0x26$TransferCnt.class);
    public final PBUInt64Field chain_id = PBField.initUInt64(0);
}

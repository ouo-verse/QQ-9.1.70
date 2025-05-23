package tencent.im.oidb.searcher;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_c2c_searcher$Iterator extends MessageMicro<oidb_c2c_searcher$Iterator> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"complete", "uin", "key"}, new Object[]{Boolean.FALSE, 0L, null}, oidb_c2c_searcher$Iterator.class);
    public final PBBoolField complete = PBField.initBool(false);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public oidb_c2c_searcher$MsgKey key = new oidb_c2c_searcher$MsgKey();
}

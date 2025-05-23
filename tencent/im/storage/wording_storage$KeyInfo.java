package tencent.im.storage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class wording_storage$KeyInfo extends MessageMicro<wording_storage$KeyInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"type", "key"}, new Object[]{0, 0L}, wording_storage$KeyInfo.class);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt64Field key = PBField.initUInt64(0);
}

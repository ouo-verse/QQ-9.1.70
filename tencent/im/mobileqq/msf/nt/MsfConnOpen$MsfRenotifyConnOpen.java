package tencent.im.mobileqq.msf.nt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class MsfConnOpen$MsfRenotifyConnOpen extends MessageMicro<MsfConnOpen$MsfRenotifyConnOpen> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"conn_seq"}, new Object[]{0L}, MsfConnOpen$MsfRenotifyConnOpen.class);
    public final PBUInt64Field conn_seq = PBField.initUInt64(0);
}

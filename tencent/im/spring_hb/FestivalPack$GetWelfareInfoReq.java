package tencent.im.spring_hb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class FestivalPack$GetWelfareInfoReq extends MessageMicro<FestivalPack$GetWelfareInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"type"}, new Object[]{0}, FestivalPack$GetWelfareInfoReq.class);
    public final PBUInt32Field type = PBField.initUInt32(0);
}

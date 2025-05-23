package tencent.im.spring_hb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class FestivalPack$ExposePackReq extends MessageMicro<FestivalPack$ExposePackReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"pack_id"}, new Object[]{""}, FestivalPack$ExposePackReq.class);
    public final PBStringField pack_id = PBField.initString("");
}

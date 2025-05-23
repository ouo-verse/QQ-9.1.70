package tencent.im.spring_hb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes29.dex */
public final class FestivalPack$ExposePackRsp extends MessageMicro<FestivalPack$ExposePackRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"errcode"}, new Object[]{0}, FestivalPack$ExposePackRsp.class);
    public final PBInt32Field errcode = PBField.initInt32(0);
}

package tencent.im.oidb.cmd0xcd1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0xcd1$ReqBody extends MessageMicro<Oidb_0xcd1$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"get_pack_req"}, new Object[]{null}, Oidb_0xcd1$ReqBody.class);
    public Oidb_0xcd1$GetPackageShopReq get_pack_req = new MessageMicro<Oidb_0xcd1$GetPackageShopReq>() { // from class: tencent.im.oidb.cmd0xcd1.Oidb_0xcd1$GetPackageShopReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"portal_number", "client_source"}, new Object[]{0, 0}, Oidb_0xcd1$GetPackageShopReq.class);
        public final PBInt32Field portal_number = PBField.initInt32(0);
        public final PBInt32Field client_source = PBField.initInt32(0);
    };
}

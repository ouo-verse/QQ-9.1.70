package tencent.im.spring_hb;

import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class FestivalPack$NewYearEvePackReq extends MessageMicro<FestivalPack$NewYearEvePackReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{CheckForwardServlet.KEY_REQ_ID, "scene", "platform"}, new Object[]{"", 0, 0L}, FestivalPack$NewYearEvePackReq.class);
    public final PBStringField req_id = PBField.initString("");
    public final PBUInt32Field scene = PBField.initUInt32(0);
    public final PBInt64Field platform = PBField.initInt64(0);
}

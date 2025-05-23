package tvideo;

import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class TVideoLike$UserAttitudeOptionResponse extends MessageMicro<TVideoLike$UserAttitudeOptionResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{CheckForwardServlet.KEY_ERR_CODE, "err_msg", "data"}, new Object[]{0, "", null}, TVideoLike$UserAttitudeOptionResponse.class);
    public final PBInt32Field err_code = PBField.initInt32(0);
    public final PBStringField err_msg = PBField.initString("");
    public TVideoLike$UserAttitudeOption data = new TVideoLike$UserAttitudeOption();
}

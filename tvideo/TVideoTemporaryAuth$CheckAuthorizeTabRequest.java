package tvideo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class TVideoTemporaryAuth$CheckAuthorizeTabRequest extends MessageMicro<TVideoTemporaryAuth$CheckAuthorizeTabRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"authorize_source", "authorize_pgid"}, new Object[]{0, 3}, TVideoTemporaryAuth$CheckAuthorizeTabRequest.class);
    public final PBEnumField authorize_source = PBField.initEnum(0);
    public final PBEnumField authorize_pgid = PBField.initEnum(3);
}

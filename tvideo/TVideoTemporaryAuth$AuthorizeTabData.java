package tvideo;

import com.qzone.widget.u;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class TVideoTemporaryAuth$AuthorizeTabData extends MessageMicro<TVideoTemporaryAuth$AuthorizeTabData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"allow_authorize", u.COLUMN_TAB_ID}, new Object[]{Boolean.FALSE, 0}, TVideoTemporaryAuth$AuthorizeTabData.class);
    public final PBBoolField allow_authorize = PBField.initBool(false);
    public final PBInt32Field tab_id = PBField.initInt32(0);
}

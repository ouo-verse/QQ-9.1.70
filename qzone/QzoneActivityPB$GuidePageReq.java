package qzone;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes29.dex */
public final class QzoneActivityPB$GuidePageReq extends MessageMicro<QzoneActivityPB$GuidePageReq> {
    public static final int MODIFY_PAGE = 1;
    public static final int RANK_PAGE = 0;
    public static final int TASKLIST_PAGE = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{QCircleSchemeAttr.CoverFeed.SOURCE_TYPE}, new Object[]{0}, QzoneActivityPB$GuidePageReq.class);
    public final PBEnumField source_type = PBField.initEnum(0);
}

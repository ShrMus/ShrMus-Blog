package cn.shrmus.blog.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlogResourceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BlogResourceExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andResourceIdIsNull() {
            addCriterion("resource_id is null");
            return (Criteria) this;
        }

        public Criteria andResourceIdIsNotNull() {
            addCriterion("resource_id is not null");
            return (Criteria) this;
        }

        public Criteria andResourceIdEqualTo(Integer value) {
            addCriterion("resource_id =", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdNotEqualTo(Integer value) {
            addCriterion("resource_id <>", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdGreaterThan(Integer value) {
            addCriterion("resource_id >", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("resource_id >=", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdLessThan(Integer value) {
            addCriterion("resource_id <", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdLessThanOrEqualTo(Integer value) {
            addCriterion("resource_id <=", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdIn(List<Integer> values) {
            addCriterion("resource_id in", values, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdNotIn(List<Integer> values) {
            addCriterion("resource_id not in", values, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdBetween(Integer value1, Integer value2) {
            addCriterion("resource_id between", value1, value2, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("resource_id not between", value1, value2, "resourceId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andResourceIspassIsNull() {
            addCriterion("resource_ispass is null");
            return (Criteria) this;
        }

        public Criteria andResourceIspassIsNotNull() {
            addCriterion("resource_ispass is not null");
            return (Criteria) this;
        }

        public Criteria andResourceIspassEqualTo(Integer value) {
            addCriterion("resource_ispass =", value, "resourceIspass");
            return (Criteria) this;
        }

        public Criteria andResourceIspassNotEqualTo(Integer value) {
            addCriterion("resource_ispass <>", value, "resourceIspass");
            return (Criteria) this;
        }

        public Criteria andResourceIspassGreaterThan(Integer value) {
            addCriterion("resource_ispass >", value, "resourceIspass");
            return (Criteria) this;
        }

        public Criteria andResourceIspassGreaterThanOrEqualTo(Integer value) {
            addCriterion("resource_ispass >=", value, "resourceIspass");
            return (Criteria) this;
        }

        public Criteria andResourceIspassLessThan(Integer value) {
            addCriterion("resource_ispass <", value, "resourceIspass");
            return (Criteria) this;
        }

        public Criteria andResourceIspassLessThanOrEqualTo(Integer value) {
            addCriterion("resource_ispass <=", value, "resourceIspass");
            return (Criteria) this;
        }

        public Criteria andResourceIspassIn(List<Integer> values) {
            addCriterion("resource_ispass in", values, "resourceIspass");
            return (Criteria) this;
        }

        public Criteria andResourceIspassNotIn(List<Integer> values) {
            addCriterion("resource_ispass not in", values, "resourceIspass");
            return (Criteria) this;
        }

        public Criteria andResourceIspassBetween(Integer value1, Integer value2) {
            addCriterion("resource_ispass between", value1, value2, "resourceIspass");
            return (Criteria) this;
        }

        public Criteria andResourceIspassNotBetween(Integer value1, Integer value2) {
            addCriterion("resource_ispass not between", value1, value2, "resourceIspass");
            return (Criteria) this;
        }

        public Criteria andResourceIntegralIsNull() {
            addCriterion("resource_integral is null");
            return (Criteria) this;
        }

        public Criteria andResourceIntegralIsNotNull() {
            addCriterion("resource_integral is not null");
            return (Criteria) this;
        }

        public Criteria andResourceIntegralEqualTo(Integer value) {
            addCriterion("resource_integral =", value, "resourceIntegral");
            return (Criteria) this;
        }

        public Criteria andResourceIntegralNotEqualTo(Integer value) {
            addCriterion("resource_integral <>", value, "resourceIntegral");
            return (Criteria) this;
        }

        public Criteria andResourceIntegralGreaterThan(Integer value) {
            addCriterion("resource_integral >", value, "resourceIntegral");
            return (Criteria) this;
        }

        public Criteria andResourceIntegralGreaterThanOrEqualTo(Integer value) {
            addCriterion("resource_integral >=", value, "resourceIntegral");
            return (Criteria) this;
        }

        public Criteria andResourceIntegralLessThan(Integer value) {
            addCriterion("resource_integral <", value, "resourceIntegral");
            return (Criteria) this;
        }

        public Criteria andResourceIntegralLessThanOrEqualTo(Integer value) {
            addCriterion("resource_integral <=", value, "resourceIntegral");
            return (Criteria) this;
        }

        public Criteria andResourceIntegralIn(List<Integer> values) {
            addCriterion("resource_integral in", values, "resourceIntegral");
            return (Criteria) this;
        }

        public Criteria andResourceIntegralNotIn(List<Integer> values) {
            addCriterion("resource_integral not in", values, "resourceIntegral");
            return (Criteria) this;
        }

        public Criteria andResourceIntegralBetween(Integer value1, Integer value2) {
            addCriterion("resource_integral between", value1, value2, "resourceIntegral");
            return (Criteria) this;
        }

        public Criteria andResourceIntegralNotBetween(Integer value1, Integer value2) {
            addCriterion("resource_integral not between", value1, value2, "resourceIntegral");
            return (Criteria) this;
        }

        public Criteria andResourceUrlIsNull() {
            addCriterion("resource_url is null");
            return (Criteria) this;
        }

        public Criteria andResourceUrlIsNotNull() {
            addCriterion("resource_url is not null");
            return (Criteria) this;
        }

        public Criteria andResourceUrlEqualTo(String value) {
            addCriterion("resource_url =", value, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlNotEqualTo(String value) {
            addCriterion("resource_url <>", value, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlGreaterThan(String value) {
            addCriterion("resource_url >", value, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlGreaterThanOrEqualTo(String value) {
            addCriterion("resource_url >=", value, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlLessThan(String value) {
            addCriterion("resource_url <", value, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlLessThanOrEqualTo(String value) {
            addCriterion("resource_url <=", value, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlLike(String value) {
            addCriterion("resource_url like", value, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlNotLike(String value) {
            addCriterion("resource_url not like", value, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlIn(List<String> values) {
            addCriterion("resource_url in", values, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlNotIn(List<String> values) {
            addCriterion("resource_url not in", values, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlBetween(String value1, String value2) {
            addCriterion("resource_url between", value1, value2, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlNotBetween(String value1, String value2) {
            addCriterion("resource_url not between", value1, value2, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceSizeIsNull() {
            addCriterion("resource_size is null");
            return (Criteria) this;
        }

        public Criteria andResourceSizeIsNotNull() {
            addCriterion("resource_size is not null");
            return (Criteria) this;
        }

        public Criteria andResourceSizeEqualTo(Integer value) {
            addCriterion("resource_size =", value, "resourceSize");
            return (Criteria) this;
        }

        public Criteria andResourceSizeNotEqualTo(Integer value) {
            addCriterion("resource_size <>", value, "resourceSize");
            return (Criteria) this;
        }

        public Criteria andResourceSizeGreaterThan(Integer value) {
            addCriterion("resource_size >", value, "resourceSize");
            return (Criteria) this;
        }

        public Criteria andResourceSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("resource_size >=", value, "resourceSize");
            return (Criteria) this;
        }

        public Criteria andResourceSizeLessThan(Integer value) {
            addCriterion("resource_size <", value, "resourceSize");
            return (Criteria) this;
        }

        public Criteria andResourceSizeLessThanOrEqualTo(Integer value) {
            addCriterion("resource_size <=", value, "resourceSize");
            return (Criteria) this;
        }

        public Criteria andResourceSizeIn(List<Integer> values) {
            addCriterion("resource_size in", values, "resourceSize");
            return (Criteria) this;
        }

        public Criteria andResourceSizeNotIn(List<Integer> values) {
            addCriterion("resource_size not in", values, "resourceSize");
            return (Criteria) this;
        }

        public Criteria andResourceSizeBetween(Integer value1, Integer value2) {
            addCriterion("resource_size between", value1, value2, "resourceSize");
            return (Criteria) this;
        }

        public Criteria andResourceSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("resource_size not between", value1, value2, "resourceSize");
            return (Criteria) this;
        }

        public Criteria andResourceDownloadCountIsNull() {
            addCriterion("resource_download_count is null");
            return (Criteria) this;
        }

        public Criteria andResourceDownloadCountIsNotNull() {
            addCriterion("resource_download_count is not null");
            return (Criteria) this;
        }

        public Criteria andResourceDownloadCountEqualTo(Integer value) {
            addCriterion("resource_download_count =", value, "resourceDownloadCount");
            return (Criteria) this;
        }

        public Criteria andResourceDownloadCountNotEqualTo(Integer value) {
            addCriterion("resource_download_count <>", value, "resourceDownloadCount");
            return (Criteria) this;
        }

        public Criteria andResourceDownloadCountGreaterThan(Integer value) {
            addCriterion("resource_download_count >", value, "resourceDownloadCount");
            return (Criteria) this;
        }

        public Criteria andResourceDownloadCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("resource_download_count >=", value, "resourceDownloadCount");
            return (Criteria) this;
        }

        public Criteria andResourceDownloadCountLessThan(Integer value) {
            addCriterion("resource_download_count <", value, "resourceDownloadCount");
            return (Criteria) this;
        }

        public Criteria andResourceDownloadCountLessThanOrEqualTo(Integer value) {
            addCriterion("resource_download_count <=", value, "resourceDownloadCount");
            return (Criteria) this;
        }

        public Criteria andResourceDownloadCountIn(List<Integer> values) {
            addCriterion("resource_download_count in", values, "resourceDownloadCount");
            return (Criteria) this;
        }

        public Criteria andResourceDownloadCountNotIn(List<Integer> values) {
            addCriterion("resource_download_count not in", values, "resourceDownloadCount");
            return (Criteria) this;
        }

        public Criteria andResourceDownloadCountBetween(Integer value1, Integer value2) {
            addCriterion("resource_download_count between", value1, value2, "resourceDownloadCount");
            return (Criteria) this;
        }

        public Criteria andResourceDownloadCountNotBetween(Integer value1, Integer value2) {
            addCriterion("resource_download_count not between", value1, value2, "resourceDownloadCount");
            return (Criteria) this;
        }

        public Criteria andResourceNameIsNull() {
            addCriterion("resource_name is null");
            return (Criteria) this;
        }

        public Criteria andResourceNameIsNotNull() {
            addCriterion("resource_name is not null");
            return (Criteria) this;
        }

        public Criteria andResourceNameEqualTo(String value) {
            addCriterion("resource_name =", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotEqualTo(String value) {
            addCriterion("resource_name <>", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameGreaterThan(String value) {
            addCriterion("resource_name >", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameGreaterThanOrEqualTo(String value) {
            addCriterion("resource_name >=", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameLessThan(String value) {
            addCriterion("resource_name <", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameLessThanOrEqualTo(String value) {
            addCriterion("resource_name <=", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameLike(String value) {
            addCriterion("resource_name like", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotLike(String value) {
            addCriterion("resource_name not like", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameIn(List<String> values) {
            addCriterion("resource_name in", values, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotIn(List<String> values) {
            addCriterion("resource_name not in", values, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameBetween(String value1, String value2) {
            addCriterion("resource_name between", value1, value2, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotBetween(String value1, String value2) {
            addCriterion("resource_name not between", value1, value2, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceDescriptionIsNull() {
            addCriterion("resource_description is null");
            return (Criteria) this;
        }

        public Criteria andResourceDescriptionIsNotNull() {
            addCriterion("resource_description is not null");
            return (Criteria) this;
        }

        public Criteria andResourceDescriptionEqualTo(String value) {
            addCriterion("resource_description =", value, "resourceDescription");
            return (Criteria) this;
        }

        public Criteria andResourceDescriptionNotEqualTo(String value) {
            addCriterion("resource_description <>", value, "resourceDescription");
            return (Criteria) this;
        }

        public Criteria andResourceDescriptionGreaterThan(String value) {
            addCriterion("resource_description >", value, "resourceDescription");
            return (Criteria) this;
        }

        public Criteria andResourceDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("resource_description >=", value, "resourceDescription");
            return (Criteria) this;
        }

        public Criteria andResourceDescriptionLessThan(String value) {
            addCriterion("resource_description <", value, "resourceDescription");
            return (Criteria) this;
        }

        public Criteria andResourceDescriptionLessThanOrEqualTo(String value) {
            addCriterion("resource_description <=", value, "resourceDescription");
            return (Criteria) this;
        }

        public Criteria andResourceDescriptionLike(String value) {
            addCriterion("resource_description like", value, "resourceDescription");
            return (Criteria) this;
        }

        public Criteria andResourceDescriptionNotLike(String value) {
            addCriterion("resource_description not like", value, "resourceDescription");
            return (Criteria) this;
        }

        public Criteria andResourceDescriptionIn(List<String> values) {
            addCriterion("resource_description in", values, "resourceDescription");
            return (Criteria) this;
        }

        public Criteria andResourceDescriptionNotIn(List<String> values) {
            addCriterion("resource_description not in", values, "resourceDescription");
            return (Criteria) this;
        }

        public Criteria andResourceDescriptionBetween(String value1, String value2) {
            addCriterion("resource_description between", value1, value2, "resourceDescription");
            return (Criteria) this;
        }

        public Criteria andResourceDescriptionNotBetween(String value1, String value2) {
            addCriterion("resource_description not between", value1, value2, "resourceDescription");
            return (Criteria) this;
        }

        public Criteria andResourceUploadTimeIsNull() {
            addCriterion("resource_upload_time is null");
            return (Criteria) this;
        }

        public Criteria andResourceUploadTimeIsNotNull() {
            addCriterion("resource_upload_time is not null");
            return (Criteria) this;
        }

        public Criteria andResourceUploadTimeEqualTo(Date value) {
            addCriterion("resource_upload_time =", value, "resourceUploadTime");
            return (Criteria) this;
        }

        public Criteria andResourceUploadTimeNotEqualTo(Date value) {
            addCriterion("resource_upload_time <>", value, "resourceUploadTime");
            return (Criteria) this;
        }

        public Criteria andResourceUploadTimeGreaterThan(Date value) {
            addCriterion("resource_upload_time >", value, "resourceUploadTime");
            return (Criteria) this;
        }

        public Criteria andResourceUploadTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("resource_upload_time >=", value, "resourceUploadTime");
            return (Criteria) this;
        }

        public Criteria andResourceUploadTimeLessThan(Date value) {
            addCriterion("resource_upload_time <", value, "resourceUploadTime");
            return (Criteria) this;
        }

        public Criteria andResourceUploadTimeLessThanOrEqualTo(Date value) {
            addCriterion("resource_upload_time <=", value, "resourceUploadTime");
            return (Criteria) this;
        }

        public Criteria andResourceUploadTimeIn(List<Date> values) {
            addCriterion("resource_upload_time in", values, "resourceUploadTime");
            return (Criteria) this;
        }

        public Criteria andResourceUploadTimeNotIn(List<Date> values) {
            addCriterion("resource_upload_time not in", values, "resourceUploadTime");
            return (Criteria) this;
        }

        public Criteria andResourceUploadTimeBetween(Date value1, Date value2) {
            addCriterion("resource_upload_time between", value1, value2, "resourceUploadTime");
            return (Criteria) this;
        }

        public Criteria andResourceUploadTimeNotBetween(Date value1, Date value2) {
            addCriterion("resource_upload_time not between", value1, value2, "resourceUploadTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
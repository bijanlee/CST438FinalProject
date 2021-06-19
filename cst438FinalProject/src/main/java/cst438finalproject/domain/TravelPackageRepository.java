package cst438finalproject.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TravelPackageRepository extends CrudRepository<TravelPackage, Long>
{
   @Query("select p from packages p where p.user_id = ?1")
   List<TravelPackage> findAllTravelPackagesByUserId(int userId);
   
   @Query("select p from packages p where p.package_id = ?1")
   List<TravelPackage> findByPackageId(int packageId);
   
   @Query("delete from packages where package_id = ?1")
   void deletePackageById(int id);
}
